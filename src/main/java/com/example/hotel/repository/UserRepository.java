package com.example.hotel.repository;


import com.example.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByCustomerId(Long customerId);

    User findByUsername(String username);
}
