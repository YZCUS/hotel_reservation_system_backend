package com.example.hotel.repository;

import com.example.hotel.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByEmail(String email);

    List<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
