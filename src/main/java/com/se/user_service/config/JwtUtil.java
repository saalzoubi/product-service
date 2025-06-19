package com.se.user_service.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.se.user_service.dto.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.config.secret}")
    private String SECRET_KEY;

    @Value("${jwt.config.expire}")
    private long EXPIRATION_MS;

    public String generateToken(CustomUserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("name", userDetails.getName())
                .withClaim("email", userDetails.getEmail())
                .withClaim("phoneNumber", userDetails.getPhoneNumber())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String validateAndGetUsername(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(token);
        return decodedJWT.getSubject();
    }
}

