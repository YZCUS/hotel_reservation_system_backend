package com.example.hotel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_generator")
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "hotel_id", insertable = false, updatable = false)
    private Long hotelId;
    private String number;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    private Hotel hotel;
    private String type;
    @Column(name = "bed_number")
    private Integer bedNumber;
    private Integer capacity;
    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;

    public Room(Long roomId, Long hotelId, String number, String type, Integer bedNumber, Integer capacity, BigDecimal pricePerNight) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.number = number;
        this.type = type;
        this.bedNumber = bedNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public Room(Long hotelId, String number, String type, Integer bedNumber, Integer capacity, BigDecimal pricePerNight) {
        this.hotelId = hotelId;
        this.number = number;
        this.type = type;
        this.bedNumber = bedNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public Room() {

    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }


}
