package lkijse.OnlineBookstoreApplication.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import lkijse.OnlineBookstoreApplication.repository.JwtTokenUtil;
import lkijse.OnlineBookstoreApplication.repository.LoginRequest;
import lkijse.OnlineBookstoreApplication.repository.LoginResponse;
import lkijse.OnlineBookstoreApplication.repository.RegisterRequest;
import lkijse.OnlineBookstoreApplication.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        
        if (userService.isUsernameTaken(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }

        // Example registration logic:
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());
        // Set other user attributes as needed
        // Use userService or userRepository to save the user to the database

        // Return a success response if registration is successful
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public <T> ResponseEntity<T> loginUser(@RequestBody LoginRequest loginRequest) {
        // Implement user login logic here (e.g., authenticate user credentials)
        // Use Spring Security's AuthenticationManager or a custom authentication logic

        // Example authentication logic:
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        // You should compare the provided password with the user's stored password here
        // If authentication fails, return an error response
        
        // Assuming successful authentication, generate a JWT token
        String token = jwtTokenUtil.generateToken(userDetails);

        // Return the JWT token in the response
        return ResponseEntity.ok((T) new LoginResponse(token));
    }
}

