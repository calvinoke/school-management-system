package com.example.backend.service;

import com.example.backend.entity.Alluser;
import com.example.backend.repository.AlluserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.backend.security.JwtTokenProvider;

import java.util.List;

@Service
public class AlluserService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AlluserRepository alluserRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ✅ Secure Registration
    public Alluser saveUser(Alluser user) {
        if (alluserRepository.existsById(user.getUsername())) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }

        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set defaults if needed
        if (user.getRole() == null) user.setRole("user");
        if (user.getImage() == null) user.setImage("default.png");

        return alluserRepository.save(user);
    }

    // ✅ Secure Login
    public Alluser login(String email, String rawPassword) {
        List<Alluser> users = alluserRepository.findAll();

        for (Alluser user : users) {
            if (user.getEmail().equals(email) && passwordEncoder.matches(rawPassword, user.getPassword())) {
                return user;
            }
        }

        throw new RuntimeException("Invalid email or password.");
    }

    public List<Alluser> getAllUsers() {
        return alluserRepository.findAll();
    }

    public Alluser getUserByUsername(String username) {
        return alluserRepository.findById(username).orElse(null);
    }

    public void deleteUser(String username) {
        alluserRepository.deleteById(username);
    }

    public Alluser updateUser(Alluser user) {
        return alluserRepository.save(user);
    }

    // Register a new user
    public Alluser registerUser(Alluser newUser) {
        if (alluserRepository.findByUsername(newUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }

        if (alluserRepository.findByEmail(newUser.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists.");
        }

        return alluserRepository.save(newUser);
    }

    // Authenticate user
    public String loginUser(String username, String rawPassword) {
        Alluser user = alluserRepository.findByUsername(username);

        if (user == null || !passwordEncoder.matches(rawPassword, user.getPassword())) {  // Fix here
            throw new IllegalArgumentException("Invalid credentials.");
        }

        return jwtTokenProvider.generateToken(user);
    }
}
