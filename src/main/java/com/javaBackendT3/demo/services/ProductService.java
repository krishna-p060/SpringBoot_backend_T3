package com.javaBackendT3.demo.services;

import com.javaBackendT3.demo.models.Product;

public interface ProductService {
    Product getProductById(Long id);
}
