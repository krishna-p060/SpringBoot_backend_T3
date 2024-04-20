package com.javaBackendT3.demo.services;

import com.javaBackendT3.demo.models.Category;
import com.javaBackendT3.demo.models.Product;
import com.javaBackendT3.demo.repositories.CategoryRepository;
import com.javaBackendT3.demo.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) {
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if(optionalCategory.isEmpty()) {
            throw new RuntimeException("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
