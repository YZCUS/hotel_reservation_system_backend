package com.example.hotel.controller;

import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Reservation;
import com.example.hotel.service.ReservationService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/history")
    public List<ReservationSummary> getReservationByCustomerId(Long customerId) {
        return reservationService.getReservationByCustomerId(customerId);
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelReservation(Long reservationId) {
        boolean isCancelled = reservationService.cancelReservation(reservationId);
        return isCancelled? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
