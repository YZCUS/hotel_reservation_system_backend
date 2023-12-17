package com.example.hotel.repository;

import com.example.hotel.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByEndDateGreaterThanEqual(Date today);
}
