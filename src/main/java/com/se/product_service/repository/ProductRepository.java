package com.se.product_service.repository;

import com.se.product_service.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    boolean existsByName(String name);
    Optional<ProductEntity> findByName(String idintifier);
}
