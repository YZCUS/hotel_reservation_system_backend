package com.example.hotel.service;

import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> findReservationByCustomerId(Long customerId){
        return reservationRepository.findReservationByCustomerId(customerId);
    }
}
