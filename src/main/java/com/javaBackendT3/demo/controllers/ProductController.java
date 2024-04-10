package com.javaBackendT3.demo.controllers;

import com.javaBackendT3.demo.dtos.ProductDto;
import com.javaBackendT3.demo.models.Product;
import com.javaBackendT3.demo.services.FakeStoreProductService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private FakeStoreProductService fakeStoreProductService;
    ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return fakeStoreProductService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return fakeStoreProductService.getAllProducts();
    }
}
