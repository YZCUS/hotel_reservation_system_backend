package com.example.hotel.service;

import com.example.hotel.dto.RegistrationRequest;
import com.example.hotel.model.Customer;
import com.example.hotel.model.User;
import com.example.hotel.repository.CustomerRepository;
import com.example.hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.hotel.util.PasswordUtils;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordUtils passwordUtils;

    @Autowired
    public UserService(UserRepository userRepository, CustomerRepository customerRepository, PasswordUtils passwordUtils) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.passwordUtils = passwordUtils;
    }
    @Transactional
    public void register(RegistrationRequest registrationRequest) {
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Create and save the customer
        Customer customer = new Customer(registrationRequest.getName(), registrationRequest.getEmail(), registrationRequest.getPhoneNumber());
        customer = customerRepository.save(customer);


        // Create and save the user
        String encryptedPassword = passwordUtils.encrypt(registrationRequest.getPassword());
        User user = new User(registrationRequest.getUsername(), encryptedPassword, customer.getCustomerId());
        userRepository.save(user);
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void changePassword(Long customerId,  String currentPassword,  String newPassword) {
        User user = userRepository.findByCustomerId(customerId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        String decryptedPassword = passwordUtils.decrypt(user.getPassword());
        if (!decryptedPassword.equals(currentPassword)) {
            throw new RuntimeException("Old password is incorrect");
        }
        String newEncryptedPassword = passwordUtils.encrypt(newPassword);
        user.setPassword(newEncryptedPassword);
        userRepository.save(user);
    }

    public void updateContact(Long customerId, String email, String phoneNumber) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customerRepository.save(customer);
    }
}
