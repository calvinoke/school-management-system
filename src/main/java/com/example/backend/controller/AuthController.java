package com.example.backend.controller;

import com.example.backend.entity.Alluser;
import com.example.backend.security.JwtUtil;
import com.example.backend.service.AlluserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AlluserService alluserService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<Alluser> signup(@RequestBody Alluser user) {
        Alluser savedUser = alluserService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Alluser user = alluserService.login(request.getEmail(), request.getPassword());
            String token = jwtUtil.generateToken(user.getUsername());

            return ResponseEntity.ok(new LoginResponse(token, user.getUsername(), user.getRole()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // DTOs
    static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    static class LoginResponse {
        private String token;
        private String username;
        private String role;

        public LoginResponse(String token, String username, String role) {
            this.token = token;
            this.username = username;
            this.role = role;
        }

        public String getToken() { return token; }
        public String getUsername() { return username; }
        public String getRole() { return role; }
    }


    
}


//package com.example.backend.controller;

//import com.example.backend.entity.Alluser;
//import com.example.backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {

    //@Autowired
    //private UserService userService;

    // Registration endpoint
    //@PostMapping("/register")
    //public Alluser register(@RequestBody Alluser newUser) {
    //    return userService.registerUser(newUser);
    //}

    // Login endpoint
    //@PostMapping("/login")
    //public String login(@RequestParam String username, @RequestParam String password) {
    //    return userService.loginUser(username, password);
    //}
//}
