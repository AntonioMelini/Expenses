package com.project.dto.request;

import java.time.LocalDateTime;

public class ExpenseRequestDto {

    private Double amount;
    private ExpenseCategoryRequestDto categoryRequestDto;
    private String description;
    private LocalDateTime date;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ExpenseCategoryRequestDto getCategoryRequestDto() {
        return categoryRequestDto;
    }

    public void setCategoryRequestDto(ExpenseCategoryRequestDto categoryRequestDto) {
        this.categoryRequestDto = categoryRequestDto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
