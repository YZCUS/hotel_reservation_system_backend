package com.example.hotel.service;

import com.example.hotel.model.User;
import com.example.hotel.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.hotel.util.PasswordUtils;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordUtils passwordUtils;
    public AuthService(UserRepository userRepository, PasswordUtils passwordUtils) {
        this.userRepository = userRepository;
        this.passwordUtils = passwordUtils;
    }

    public Long authenticateAndGetCustomerId(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        String decryptedPassword = passwordUtils.decrypt(user.getPassword());
        if (!decryptedPassword.equals(password)) {
            throw new RuntimeException("Password is incorrect");
        }
        return user.getCustomerId();
    }
}
