package com.example.hotel.service;

import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private List<String> reservationByCustomerId;

    public List<ReservationSummary> getReservationByCustomerId(Long customerId){
        return reservationRepository.getReservationByCustomerId(customerId);
    }

    public boolean cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation == null) {
            return false;
        }
        reservation.setStatus("cancelled");
        reservationRepository.save(reservation);
        return true;
    }
}




