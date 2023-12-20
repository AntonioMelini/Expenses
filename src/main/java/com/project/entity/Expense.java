package com.project.entity;

import java.time.LocalDateTime;

public class Expense {
    public Expense() {
    }

    public Expense(Long id, String description, Double amount, String date,Long category_id) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category_id = category_id;
    }
    public Expense( String description, Double amount, String date,Long category_id) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category_id = category_id;
    }

    private Long id;
    private String description;
    private Double amount;
    private Long category_id;
    private String date;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
