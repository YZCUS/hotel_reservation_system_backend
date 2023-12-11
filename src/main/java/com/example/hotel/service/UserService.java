package com.example.hotel.service;

import com.example.hotel.dto.RegistrationRequest;
import com.example.hotel.model.Customer;
import com.example.hotel.model.User;
import com.example.hotel.repository.CustomerRepository;
import com.example.hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
//        this.passwordEncoder = passwordEncoder;
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
        User user = new User(registrationRequest.getUsername(), registrationRequest.getPassword(), customer.getCustomerId());
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
        if (!user.getPassword().equals(currentPassword)) {
            throw new RuntimeException("Old password is incorrect");
        }
        user.setPassword(newPassword);
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
