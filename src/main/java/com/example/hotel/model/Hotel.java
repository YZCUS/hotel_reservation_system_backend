package com.example.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_generator")
    @Column(name = "hotel_id")
    private Long hotelId;
    @Column(name = "name")
    private String hotelName;
    @Column(name = "address_id")
    private Long addressId;
    @OneToOne
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    Address hotelAddress;
    @Column(name = "contact_number")
    private String contactNumber;
    private String email;

    public Hotel(Long hotelId, String hotelName, Long addressId, String contactNumber, String email) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.addressId = addressId;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Hotel(String hotelName, Long addressId, String contactNumber, String email) {
        this.hotelName = hotelName;
        this.addressId = addressId;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Hotel() {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Address getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(Address hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
