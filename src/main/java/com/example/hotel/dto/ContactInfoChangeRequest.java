package com.example.hotel.dto;

public class ContactInfoChangeRequest {
    private Long customerId;
    private String email;
    private String phoneNumber;

    public ContactInfoChangeRequest(Long customerId, String email, String phoneNumber) {
        this.customerId = customerId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public ContactInfoChangeRequest() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
