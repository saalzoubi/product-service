package com.se.product_service.controller;

import com.se.product_service.dto.request.addProductRequest;
import com.se.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody addProductRequest request) {
        productService.addProduct(request);
        return ResponseEntity.ok().build();
    }


}