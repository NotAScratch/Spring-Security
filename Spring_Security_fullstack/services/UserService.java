package com.example.fullstack.services;

import com.example.fullstack.controller.RegistrationRequest;
import com.example.fullstack.entities.Role;
import com.example.fullstack.entities.User;
import com.example.fullstack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    private  final UserRepository userRepository;

    private  final PasswordEncoder passwordEncoder;



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User registerUser(RegistrationRequest registration) {

        var user = new User(
                registration.getFirstName(),
                registration.getLastName(),
                registration.getEmail(),
                passwordEncoder.encode(registration.getPassword()),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);
    }

    @Override
    public User RegisterUser(RegistrationRequest registration) {

        var user = new User(
                registration.getFirstName(),
                registration.getLastName(),
                registration.getEmail(),
                passwordEncoder.encode(registration.getPassword()),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);

    }


//    @Override
//    public User RegisterUser(RegistrationRequest registration) {
//        var user = new User(registration.getFirstName(),
//                registration.getLastName(),
//                registration.getEmail(),
//                passwordEncoder.encode(registration.getPassword()),
//                Arrays.asList(new Role("ROLE_USER")));
//        return userRepository.save(user);
//    }


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

}
