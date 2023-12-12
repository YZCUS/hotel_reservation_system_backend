package com.example.hotel.controller;

import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.dto.SearchParameters;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.Room;
import com.example.hotel.service.ReservationService;
import com.example.hotel.service.RoomService;
import org.apache.catalina.connector.Response;
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

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelReservation(Long reservationId) {
        boolean isCancelled = reservationService.cancelReservation(reservationId);
        return isCancelled? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Room>> search(@RequestBody SearchParameters searchParameters) {
        List<Room> results = roomService.search(searchParameters);
        return ResponseEntity.ok(results);
    }
}
