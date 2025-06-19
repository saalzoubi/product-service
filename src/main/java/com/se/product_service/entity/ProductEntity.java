package com.se.product_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class ProductEntity {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private int quantity;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
    }
}
