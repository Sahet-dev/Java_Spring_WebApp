package com.sahet.simplewebapp.service;

import com.sahet.simplewebapp.model.Product;
import com.sahet.simplewebapp.repository.ProductRepo;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Getter
@Service
public class ProductService {
//    INJECTION
    private final ProductRepo productRepo;
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
// //////////





    public List<Product> getProducts() {
        return productRepo.findAll();
    }


    public Product getProductById(int prodId){
        return productRepo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageDate(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleteProductById(int prodId) {
        productRepo.deleteById(prodId);

    }
}
