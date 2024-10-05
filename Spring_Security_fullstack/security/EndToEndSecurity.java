package com.example.fullstack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EndToEndSecurity {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/registration/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/")
                    .permitAll()
                )
                .logout(logout -> logout
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                )
                .build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//          return http.csrf(csrf -> csrf.disable())
//                  .authorizeHttpRequests(auth -> auth
//                  .requestMatchers("/", "/registration/**")
//                  .permitAll().anyRequest().authenticated())
//                  .and()
//                  .formLogin().loginPage("/login")
//                  .usernameParameter("email").defaultSuccessUrl("/")
//                  .permitAll().and()
//                    .logout().invalidateHttpSession(true)
//                  .clearAuthentication(true)
//                  .logoutRequestMatcher("/logout")
//                  .logoutSuccessUrl("/")
//                  .and()
//                  .build();
//    }
}
