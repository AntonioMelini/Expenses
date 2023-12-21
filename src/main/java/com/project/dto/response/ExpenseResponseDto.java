package com.project.dto.response;

public class ExpenseResponseDto {
    private Double amount;
    private String category_name;
    private String description;
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
