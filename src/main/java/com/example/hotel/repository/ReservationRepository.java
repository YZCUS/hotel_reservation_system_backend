package com.example.hotel.repository;

import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationByCustomerId(Long customerId);

    @Query("SELECT new com.example.hotel.dto.ReservationSummary(r.reservationId, rm.type, rm.number, h.hotelName, r.checkInDate, r.checkOutDate, r.totalPrice, r.status) " +
            "FROM Reservation r JOIN r.room rm JOIN r.room.hotel h WHERE r.customerId = :customerId AND r.status != 'cancelled'"+"ORDER BY r.reservationId DESC")
    List<ReservationSummary> getReservationByCustomerId(@Param("customerId") Long customerId);

    List<Reservation> findByStatusAndCreatedTimeBefore(String pending, LocalDateTime fifteenMinutesAgo);

    @Query("SELECT r FROM Reservation r WHERE r.status = 'confirmed' AND r.checkInDate <= CURRENT_DATE")
    List<Reservation> findConfirmedAndPastReservations();

    List<Reservation> findReservationByRoomId(Long roomId);
}
