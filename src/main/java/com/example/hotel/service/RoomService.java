package com.example.hotel.service;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public List<Room> findAvailableRooms(String hotelName, Integer bedNumber,
                                         String roomType, BigDecimal minPrice,
                                         BigDecimal maxPrice, Date checkInDate,
                                         Date checkOutDate) {
        return roomRepository.findAvailableRooms(hotelName, bedNumber, roomType,
                minPrice, maxPrice, checkInDate, checkOutDate);
    }
}
