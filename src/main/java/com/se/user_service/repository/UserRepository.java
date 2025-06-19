package com.se.user_service.repository;

import com.se.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
    Optional<UserEntity> findByEmailOrPhoneNumber(String idintifier1, String idintifier2);
}
