package com.javaBackendT3.demo.controllers;

import com.javaBackendT3.demo.dtos.ExceptionDto;
import com.javaBackendT3.demo.dtos.ProductDto;
import com.javaBackendT3.demo.models.Category;
import com.javaBackendT3.demo.models.Product;
import com.javaBackendT3.demo.repositories.CategoryRepository;
import com.javaBackendT3.demo.services.FakeStoreProductService;
import com.javaBackendT3.demo.services.ProductService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    //private CategoryRepository categoryRepository;
    ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {


        return productService.createProduct(product);
    }
}
