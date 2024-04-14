package com.javaBackendT3.demo.services;

import com.javaBackendT3.demo.dtos.FakeStoreProductDto;
import com.javaBackendT3.demo.exceptions.ProductNotFoundException;
import com.javaBackendT3.demo.models.Category;
import com.javaBackendT3.demo.models.Product;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto  = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreProductDto != null) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());

            Category category = new Category();
            category.setDescription(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());
            return product;
        }
        throw new ProductNotFoundException(id, "Please enter a valid product id");
    }

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {

            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());

            Category category = new Category();
            category.setDescription(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());
            products.add(product);
        }
        return products;
    }
}
