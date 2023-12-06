package com.example.hotel.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_generator")
    private Long membershipId;
    @Column(name = "customer_id")
    private Long customerId;
    private String type;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private String benefits;

    public Membership(Long membershipId, Long customerId, String type, Date startDate, Date endDate, String benefits) {
        this.membershipId = membershipId;
        this.customerId = customerId;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.benefits = benefits;
    }

    public Membership(Long customerId, String type, Date startDate, Date endDate, String benefits) {
        this.customerId = customerId;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.benefits = benefits;
    }

    public Membership() {
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}

