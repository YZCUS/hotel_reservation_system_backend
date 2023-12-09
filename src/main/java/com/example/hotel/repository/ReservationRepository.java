package com.example.hotel.repository;

import com.example.hotel.dto.ReservationSummary;
import com.example.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationByCustomerId(Long customerId);

    @Query("SELECT new com.example.hotel.dto.ReservationSummary(r.reservationId, rm.type, r.checkInDate, r.checkOutDate, r.totalPrice) " + "FROM Reservation r JOIN r.room rm WHERE r.customerId = :customerId AND r.status != 'cancelled'")
    List<ReservationSummary> getReservationByCustomerId(@Param("customerId") Long customerId);

}
