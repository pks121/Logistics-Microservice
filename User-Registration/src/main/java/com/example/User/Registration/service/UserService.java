package com.example.User.Registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.User.Registration.dto.LoginDto;
import com.example.User.Registration.dto.ResponseDto;
import com.example.User.Registration.dto.UserDto;
import com.example.User.Registration.entity.User;
import com.example.User.Registration.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto createUser(User user) {

        Optional<User> existsUser = userRepository.findByEmail(user.getEmail());
        if (existsUser.isPresent()) {
            return new UserDto("failed", "User with " + user.getEmail() + " is already exists.");
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userRepository.save(user);

        return new UserDto("success", "User with " + user.getEmail() + " has been successfully created");

    }

    public ResponseDto loginUser(LoginDto loginDto) {

        Optional<User> existsUser = userRepository.findByEmail(loginDto.getEmail());
        if (existsUser.isEmpty()) {
            return new ResponseDto("failed", "no user with " + loginDto.getEmail() + " exists");
        }

        // Verify password using passwordEncoder.matches()
        if (!passwordEncoder.matches(loginDto.getPassword(), existsUser.get().getPassword())) {
            return new ResponseDto("failed", "incorrect password");
        }

        return new ResponseDto("success", "successfully logged in using " + loginDto.getEmail());

    }
}
