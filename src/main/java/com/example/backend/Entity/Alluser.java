package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

@Entity
@Table(name = "alluser")
public class Alluser {

    @Id
    private String username; // Primary key

    private String name;
    private String email;
    private String password;
    private String image;
    private String role;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Default no-args constructor
    public Alluser() {}

    // Constructor for creating a new user
    public Alluser(String username, String name, String email, String rawPassword) {
        validateEmail(email);
        validatePasswordStrength(rawPassword);

        this.username = username;
        this.name = name;
        this.email = email;
        this.password = hashPassword(rawPassword);
        this.image = null;
        this.role = "user"; // default
    }

    // Constructor for updating an existing user
    public Alluser(String username, String name, String email, String rawPassword, String image, String role) {
        validateEmail(email);
        validatePasswordStrength(rawPassword);

        this.username = username;
        this.name = name;
        this.email = email;
        this.password = hashPassword(rawPassword);
        this.image = image;
        this.role = role;
    }

    // Hash password
    private String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    // Password validation logic
    private void validatePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
    }

    // Email format validation
    private void validateEmail(String email) {
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPassword() { return password; }
    public void setPassword(String rawPassword) {
        validatePasswordStrength(rawPassword);
        this.password = hashPassword(rawPassword);
    }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Alluser{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                ", image='" + image + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
