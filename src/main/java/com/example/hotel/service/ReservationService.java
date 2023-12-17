package com.example.hotel.service;

import com.example.hotel.dto.PendingReservation;
import com.example.hotel.dto.ReservationDetails;
import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Address;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.Room;
import com.example.hotel.repository.ReservationRepository;
import com.example.hotel.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<ReservationSummary> getReservationByCustomerId(Long customerId){
        return reservationRepository.getReservationByCustomerId(customerId);
    }

    public List<Reservation> updateReservationStatus(Long customerId, Long reservationId, String newStatus) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation == null) {
            return null;
        }
        if(reservation.getStatus().equals("cancelled") && newStatus.equals("confirmed")){
            return null;
        }
        reservation.setStatus(newStatus);
        reservationRepository.save(reservation);
        return reservationRepository.findReservationByCustomerId(customerId);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation createReservation(PendingReservation pendingReservation) {
        Long roomId = pendingReservation.getRoomId();
        Long customerId = pendingReservation.getCustomerId();
        LocalDate checkInDate = pendingReservation.getCheckInDate();
        LocalDate checkOutDate = pendingReservation.getCheckOutDate();
        BigDecimal totalPrice = pendingReservation.getTotalPrice();
        String status = pendingReservation.getStatus();
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found"));

        Reservation reservation = new Reservation();
        reservation.setRoomId(roomId);
        reservation.setCustomerId(customerId);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setTotalPrice(totalPrice);
        reservation.setStatus(status);
        reservation.setRoom(room);

        // check if the room is available before saving the pending reservation
        // since it is possible that two users are trying to book the same room at the same time
        // if user are late, the room will be unavailable
        List<Reservation> reservations = reservationRepository.findReservationByRoomId(roomId);
        for (Reservation r : reservations) {
            if (r.getCheckInDate().isBefore(checkOutDate) && r.getCheckOutDate().isAfter(checkInDate) && (r.getStatus().equals("confirmed")||r.getStatus().equals("pending"))) {
                return null;
            }
        }
        return reservationRepository.save(reservation);
    }

    public ReservationDetails getReservationById(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation == null) {
            return null;
        }
        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setHotelId(reservation.getRoom().getHotel().getHotelId());
        reservationDetails.setHotelName(reservation.getRoom().getHotel().getHotelName());
        Address hotelAddressObject = reservation.getRoom().getHotel().getHotelAddress();
        String hotelAddress = hotelAddressObject.getStreetNum() + ", " +hotelAddressObject.getStreet()+", "+ hotelAddressObject.getCity() + ", "
                + hotelAddressObject.getCountry() + ", " + hotelAddressObject.getZipCode();
        reservationDetails.setHotelAddress(hotelAddress);
        reservationDetails.setRoomId(reservation.getRoomId());
        reservationDetails.setRoomType(reservation.getRoom().getType());
        reservationDetails.setBedNumber(reservation.getRoom().getBedNumber());
        reservationDetails.setCapacity(reservation.getRoom().getCapacity());
        reservationDetails.setRoomNumber(reservation.getRoom().getNumber());
        reservationDetails.setPricePerNight(reservation.getRoom().getPricePerNight());
        reservationDetails.setCheckInDate(reservation.getCheckInDate());
        reservationDetails.setCheckOutDate(reservation.getCheckOutDate());
        reservationDetails.setTotalPrice(reservation.getTotalPrice());
        return reservationDetails;
    }
}




