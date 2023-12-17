package com.example.hotel.dto;

public class PasswordChangeRequest {
    private Long customerId;
    private String currentPassword;
    private String newPassword;

    public PasswordChangeRequest() {
    }

    public PasswordChangeRequest(Long customerId, String currentPassword, String newPassword) {
        this.customerId = customerId;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCurrentPassword() { return currentPassword; }

    public void setCurrentPassword(String currentPassword) { this.currentPassword = currentPassword; }

    public String getNewPassword() { return newPassword; }

    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
