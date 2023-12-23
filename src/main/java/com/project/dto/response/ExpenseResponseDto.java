package com.project.dto.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ExpenseResponseDto {
    @NotNull(message="amount is obligatory")
    @Min(value = 0,message = "The amount cant be lowwer than 0")
    private Double amount;
    @NotNull(message="category_name is obligatory")
    @NotBlank(message = "category_name is obligatory")
    private String category_name;
    @NotNull(message="description is obligatory")
    @NotBlank(message = "description is obligatory")
    private String description;
    @NotNull(message="date is obligatory")
    @NotBlank(message = "date is obligatory")
    private String date;

    public ExpenseResponseDto(Double amount, String category_name, String description, String date) {
        this.amount = amount;
        this.category_name = category_name;
        this.description = description;
        this.date = date;
    }

    public ExpenseResponseDto() {

    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
