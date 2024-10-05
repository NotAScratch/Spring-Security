package com.example.fullstack.services;

import com.example.fullstack.repository.UserRepository;
import com.example.fullstack.security.EndToEndUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EndToEndUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(EndToEndUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
