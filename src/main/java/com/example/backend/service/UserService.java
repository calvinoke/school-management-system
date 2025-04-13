package com.example.backend.service;

import com.example.backend.entity.Alluser;
import com.example.backend.repository.AlluserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AlluserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Register a new user
    public Alluser registerUser(Alluser user) {
        if (userRepository.existsById(user.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }

        // Password is already hashed in the entity constructor
        return userRepository.save(user);
    }

    // Authenticate login
    public Alluser authenticate(String username, String rawPassword) {
        Optional<Alluser> optionalUser = userRepository.findById(username);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        Alluser user = optionalUser.get();

        if (!encoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password.");
        }

        return user;
    }
}
