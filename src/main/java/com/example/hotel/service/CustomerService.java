package com.example.hotel.service;

import com.example.hotel.model.Customer;
import com.example.hotel.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
    public List<Customer> findCustomerByPhone(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }
    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
