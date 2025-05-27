package com.example.User.Registration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for API endpoints
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register/**").permitAll() // Allow all requests to /register endpoints
                .anyRequest().authenticated() // Require authentication for any other endpoint
                );

        return http.build();
    }
}
