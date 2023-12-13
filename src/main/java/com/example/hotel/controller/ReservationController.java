package com.example.hotel.controller;

import com.example.hotel.dto.ReservationDetails;
import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.dto.SearchParameters;
import com.example.hotel.dto.PendingReservation;
import com.example.hotel.model.Reservation;
import com.example.hotel.service.ReservationService;
import com.example.hotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final RoomService roomService;
    public ReservationController(ReservationService reservationService, RoomService roomService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
    }
    @PostMapping("/history")
    public List<ReservationSummary> getReservationByCustomerId(Long customerId) {
        return reservationService.getReservationByCustomerId(customerId);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateReservationStatus(@RequestParam Long reservationId, @RequestParam String newStatus) {
        boolean isUpdateReservation = reservationService.updateReservationStatus(reservationId, newStatus);
        if (isUpdateReservation) {
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<ReservationDetails>> search(@RequestBody SearchParameters searchParameters) {
        List<ReservationDetails> results = roomService.search(searchParameters);
        return ResponseEntity.ok(results);
    }
    @PostMapping("/pending")
    public ResponseEntity<Reservation> createReservation(@RequestBody PendingReservation pendingReservation) {
        Reservation newReservation = reservationService.createReservation(pendingReservation);
        return ResponseEntity.ok(newReservation);
    }
}
