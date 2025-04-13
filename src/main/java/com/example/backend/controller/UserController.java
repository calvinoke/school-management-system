package com.example.backend.controller;

import com.example.backend.entity.Alluser;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin // Enable this if you're calling from Flutter frontend
public class UserController {

    @Autowired
    private UserService userService;

    // Register endpoint
    @PostMapping("/register")
    public Alluser register(@RequestBody Alluser user) {
        return userService.registerUser(user);
    }

    // Login endpoint
    @PostMapping("/login")
    public Alluser login(@RequestBody LoginRequest request) {
        return userService.authenticate(request.getUsername(), request.getPassword());
    }

    // DTO class to accept login input
    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
