package com.example.fullstack.services;

import com.example.fullstack.controller.RegistrationRequest;
import com.example.fullstack.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> findByEmail(String email);
    User RegisterUser(RegistrationRequest registrationRequest);
    boolean existsByEmail(String email);

    User registerUser(RegistrationRequest registration);
}
