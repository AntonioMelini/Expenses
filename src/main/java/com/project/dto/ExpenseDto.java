package com.project.dto;

import java.time.LocalDateTime;

public class ExpenseDto {
    private String description;
    private Double amount;
    private Long categoryId;
    private LocalDateTime date;

    public ExpenseDto() {

    }

    public ExpenseDto(String description, Double amount, Long categoryId, LocalDateTime date) {
        this.description = description;
        this.amount = amount;
        this.categoryId = categoryId;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
