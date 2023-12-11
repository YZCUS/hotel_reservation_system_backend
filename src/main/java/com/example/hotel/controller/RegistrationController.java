package com.example.hotel.controller;

import com.example.hotel.dto.RegistrationRequest;
import com.example.hotel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/customer/check")
    public ResponseEntity<?> checkUsernameExists(@RequestParam String username) {
        boolean exists = userService.existsByUsername(username);
        return ResponseEntity.ok(Map.of("exists", exists));
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        try {
            userService.register(registrationRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}
