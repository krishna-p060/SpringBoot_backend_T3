package com.javaBackendT3.demo.services;

import com.javaBackendT3.demo.dtos.FakeStoreProductDto;
import com.javaBackendT3.demo.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto  = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreProductDto != null) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            //product.setCategory(fakeStoreProductDto.getCategory());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImage(fakeStoreProductDto.getImage());
            return product;
        }
        return null;
    }
}
