package com.example.hotel.service;

import com.example.hotel.dto.PendingReservation;
import com.example.hotel.dto.ReservationDetails;
import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.Room;
import com.example.hotel.repository.ReservationRepository;
import com.example.hotel.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private List<String> reservationByCustomerId;
    @Autowired
    private RoomRepository roomRepository;

    public List<ReservationSummary> getReservationByCustomerId(Long customerId){
        return reservationRepository.getReservationByCustomerId(customerId);
    }

    public boolean updateReservationStatus(Long reservationId, String newStatus) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation == null) {
            return false;
        }
        reservation.setStatus(newStatus);
        reservationRepository.save(reservation);
        return true;
    }

    public Reservation createReservation(PendingReservation pendingReservation) {
        Long roomId = pendingReservation.getRoomId();
        Long customerId = pendingReservation.getCustomerId();
        LocalDate checkInDate = pendingReservation.getCheckInDate();
        LocalDate checkOutDate = pendingReservation.getCheckOutDate();
        BigDecimal totalPrice = pendingReservation.getTotalPrice();
        String status = pendingReservation.getStatus();
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found"));
        if (room == null) {
            throw new RuntimeException("Room not found");
        }

        Reservation reservation = new Reservation();
        reservation.setRoomId(roomId);
        reservation.setCustomerId(customerId);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setTotalPrice(totalPrice);
        reservation.setStatus(status);
        reservation.setRoom(room);

        return reservationRepository.save(reservation);
    }
}




