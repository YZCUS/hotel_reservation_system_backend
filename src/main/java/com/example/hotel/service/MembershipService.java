package com.example.hotel.service;

import com.example.hotel.model.Membership;
import com.example.hotel.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;
    public List<Membership> findAllActiveMemberships(){
        return membershipRepository.findByEndDateGreaterThanEqual(new Date());
    }
}
