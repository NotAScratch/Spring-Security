package com.example.fullstack.services;

import com.example.fullstack.entities.User;
import com.example.fullstack.entities.VerificationToken;

import java.util.Optional;

public interface IVerificationTokenService {
    String validateToken(String token);
    void saveVerificationTokenForUser(User user, String token);
    Optional<VerificationToken> findByToken(String token);
}
