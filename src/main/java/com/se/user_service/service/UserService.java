package com.se.user_service.service;

import com.se.user_service.dto.request.UserRegistrationRequest;
import com.se.user_service.entity.UserEntity;
import com.se.user_service.exception.UserServiceException;
import com.se.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void registerUser(UserRegistrationRequest request) {
        boolean exists = userRepository.existsByEmailOrPhoneNumber(request.getEmail(), request.getPhoneNumber());
        if (exists) {
            throw new UserServiceException("User already exists");
        }
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        userRepository.save(user);
    }
}
