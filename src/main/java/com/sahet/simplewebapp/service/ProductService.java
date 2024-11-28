package com.sahet.simplewebapp.service;

import com.sahet.simplewebapp.model.Product;
import com.sahet.simplewebapp.repository.ProductRepo;
import lombok.Getter;
import org.springframework.stereotype.Service;

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

    public void addProduct(Product prod){
        productRepo.save(prod);
    }

    public void updateProduct(Product prod) {
        productRepo.save(prod);
    }

    public void deleteProductById(int prodId) {
        productRepo.deleteById(prodId);

    }
}
