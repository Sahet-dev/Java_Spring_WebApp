package com.sahet.simplewebapp.controller;

import com.sahet.simplewebapp.model.Product;
import com.sahet.simplewebapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {

//    CONSTRUCTOR INJECTION
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product product = productService.getProductById(prodId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }






    @PostMapping("/products")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile)
    {
        try{
            System.out.println(product);
            Product product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/{productId}/image")
    public ResponseEntity<?> getProductImageById(@PathVariable int productId){
        Product product = productService.getProductById(productId);
        byte[] imageFile = product.getImageDate();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product,
                                           @RequestPart MultipartFile imageFile){
        Product product2 = null;
        try{
            product2 = productService.updateProduct(id, product, imageFile);
        } catch (Exception e){
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
        if (product2 != null) {
            return new ResponseEntity<>("Product Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("keyword") String keyword){
        System.out.println("Searching with " + keyword);
        List<Product> products = productService.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



}
