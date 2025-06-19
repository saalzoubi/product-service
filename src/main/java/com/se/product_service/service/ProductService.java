package com.se.product_service.service;

import com.se.product_service.dto.request.addProductRequest;
import com.se.product_service.entity.ProductEntity;
import com.se.product_service.exception.ProductServiceException;
import com.se.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public void addProduct(addProductRequest request) {
        boolean exists = productRepository.existsByName(request.getName());
        if (exists) {
            throw new ProductServiceException("Product already exists");
        }
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        productRepository.save(product);
    }
}
