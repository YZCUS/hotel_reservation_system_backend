package com.example.hotel.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SearchParameters {
    private String hotelBrand;
    private Integer bedNumber;
    private String roomType;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public SearchParameters(String hotelBrand, Integer bedNumber, String roomType, BigDecimal minPrice, BigDecimal maxPrice, LocalDate checkInDate, LocalDate checkOutDate) {
        this.hotelBrand = hotelBrand;
        this.bedNumber = bedNumber;
        this.roomType = roomType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public SearchParameters() {
    }

    public String getHotelBrand() {
        return hotelBrand;
    }

    public void setHotelBrand(String hotelBrand) {
        this.hotelBrand = hotelBrand;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
