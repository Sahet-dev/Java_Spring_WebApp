package com.sahet.simplewebapp.service;

import com.sahet.simplewebapp.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(1, "iPhone", 1200),
            new Product(2, "Camera Wwowo", 800),
            new Product(3, "Charger", 30)));

    public List<Product> products(){
        return products;
    }

    public Product getProductById(int prodId){
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().get();
    }

    public void addProduct(Product prod){
        products.add(prod);
    }
}
