package com.example.hotel.repository;

import com.example.hotel.dto.ReservationDetails;
import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    @Query("SELECT new com.example.hotel.dto.ReservationDetails(h.hotelId, h.hotelName, concat(a.streetNum,', ',a.street,', ',a.city,', ',a.country,', ',a.zipCode), " +
            "r.roomId, r.type, r.bedNumber, r.capacity, r.number, r.pricePerNight, :checkInDate, :checkOutDate, r.pricePerNight) " +
            "FROM Room r JOIN Hotel h ON r.hotelId = h.hotelId " +
            "JOIN Address a ON h.addressId = a.addressId " +
            "WHERE "+
            "(r.hotel.hotelName LIKE :hotelBrand) AND " +
            "(r.bedNumber = :bedNumber) AND " +
            "(r.type LIKE :roomType) AND " +
            "(r.pricePerNight >= :minPrice) AND " +
            "(r.pricePerNight <= :maxPrice) AND " +
            "NOT EXISTS (SELECT res FROM Reservation res WHERE res.room = r AND " +
            "(((res.checkInDate <= :checkOutDate) AND " +
            "(res.checkOutDate >= :checkInDate))) AND res.status = 'pending' OR res.status = 'active')")
    List<ReservationDetails> findAvailableRooms(String hotelBrand, Integer bedNumber, String roomType,
                                                BigDecimal minPrice, BigDecimal maxPrice,
                                                LocalDate checkInDate, LocalDate checkOutDate);


    Optional<Room> findByRoomId(Long roomId);

}
