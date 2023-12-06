package com.example.hotel.repository;

import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    @Query("SELECT r FROM Room r WHERE r.hotel.hotelName = :hotelName AND " +
            "r.bedNumber = :bedNumber AND r.type = :roomType AND " +
            "r.pricePerNight BETWEEN :minPrice AND :maxPrice AND " +
            "NOT EXISTS (SELECT res FROM Reservation res WHERE res.room = r AND " +
            "((res.checkInDate <= :checkOutDate AND res.checkOutDate >= :checkInDate)))")
    List<Room> findAvailableRooms(String hotelName, Integer bedNumber, String roomType,
                                  BigDecimal minPrice, BigDecimal maxPrice,
                                  Date checkInDate, Date checkOutDate);
}
