package com.example.hotel.controller;

import com.example.hotel.dto.ContactInfoChangeRequest;
import com.example.hotel.dto.PasswordChangeRequest;
import com.example.hotel.model.Customer;
import com.example.hotel.service.CustomerService;
import com.example.hotel.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;
    private final CustomerService customerService;
    public ProfileController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }
    @PostMapping("/change_password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
        userService.changePassword(passwordChangeRequest.getCustomerId(), passwordChangeRequest.getCurrentPassword(), passwordChangeRequest.getNewPassword());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update_contact")
    public ResponseEntity<?> updateContact(@RequestBody ContactInfoChangeRequest contactInfoChange) {
        userService.updateContact(contactInfoChange.getCustomerId(), contactInfoChange.getEmail(), contactInfoChange.getPhoneNumber());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getCustomerInfo/{customerId}")
    public ResponseEntity<?> getCustomerInfo(@PathVariable Long customerId) {
        System.out.println("customerId: " + customerId);
        return ResponseEntity.ok(customerService.getCustomerInfo(customerId));
    }
}
