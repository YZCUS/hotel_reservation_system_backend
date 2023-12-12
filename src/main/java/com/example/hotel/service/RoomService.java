package com.example.hotel.service;

import com.example.hotel.dto.SearchParameters;
import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.math.BigDecimal;
import java.time.LocalDate;
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
                                         BigDecimal maxPrice, LocalDate checkInDate,
                                         LocalDate checkOutDate) {
        return roomRepository.findAvailableRooms(hotelName, bedNumber, roomType,
                minPrice, maxPrice, checkInDate, checkOutDate);
    }

    public List<Room> search(SearchParameters searchParameters) {
        String hotelBrand = searchParameters.getHotelBrand();
        String likeHotelName = (hotelBrand!=null)? ("%" + hotelBrand + "%") : "%";
        BigDecimal minPrice = searchParameters.getMinPrice();
        BigDecimal effectiveMinPrice = minPrice != null ? minPrice : BigDecimal.ZERO;
        BigDecimal maxPrice = searchParameters.getMaxPrice();
        BigDecimal effectiveMaxPrice = maxPrice != null ? maxPrice : BigDecimal.valueOf(1000000);
        String roomType = searchParameters.getRoomType();
        String effectiveRoomType = roomType != null ? (roomType + "%") : "%";

        return roomRepository.findAvailableRooms(likeHotelName,
                searchParameters.getBedNumber(), effectiveRoomType,
                effectiveMinPrice, effectiveMaxPrice,
                searchParameters.getCheckInDate(), searchParameters.getCheckOutDate());
    }
}
