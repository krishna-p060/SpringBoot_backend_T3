package com.javaBackendT3.demo.services;

import com.javaBackendT3.demo.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
