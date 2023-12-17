package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotel.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
