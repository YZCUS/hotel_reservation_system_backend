package com.example.hotel.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue
    private Long discountId;
    private String code;
    private String description;
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private String conditions;
    private boolean isMembership;

    public Discount(Long discountId, String code, String description, BigDecimal discountPercent, Date startDate, Date endDate, String conditions, boolean isMembership) {
        this.discountId = discountId;
        this.code = code;
        this.description = description;
        this.discountPercent = discountPercent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.conditions = conditions;
        this.isMembership = isMembership;
    }

    public Discount(String code, String description, BigDecimal discountPercent, Date startDate, Date endDate, String conditions, boolean isMembership) {
        this.code = code;
        this.description = description;
        this.discountPercent = discountPercent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.conditions = conditions;
        this.isMembership = isMembership;
    }

    public Discount() {

    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
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

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public boolean isMembership() {
        return isMembership;
    }

    public void setMembership(boolean membership) {
        isMembership = membership;
    }
}
