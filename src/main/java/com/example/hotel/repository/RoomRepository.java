package com.example.hotel.repository;

import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    @Query("SELECT r FROM Room r WHERE "+
            "(r.hotel.hotelName LIKE :hotelBrand) AND " +
            "(r.bedNumber = :bedNumber) AND " +
            "(r.type LIKE :roomType) AND " +
            "(r.pricePerNight >= :minPrice) AND " +
            "(r.pricePerNight <= :maxPrice) AND " +
            "NOT EXISTS (SELECT res FROM Reservation res WHERE res.room = r AND " +
            "(((res.checkInDate <= :checkOutDate) AND " +
            "(res.checkOutDate >= :checkInDate))))")
    List<Room> findAvailableRooms(String hotelBrand, Integer bedNumber, String roomType,
                                  BigDecimal minPrice, BigDecimal maxPrice,
                                  LocalDate checkInDate, LocalDate checkOutDate);
}
