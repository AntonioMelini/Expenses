package com.project.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class ExpenseRequestDto {
@Valid
    @NotNull(message="amount is obligatory")
    @Min(value = 0,message = "The amount cant be lowwer than 0")
    private Double amount;
    @NotNull(message="category_id is obligatory")
    @Min(value = 1,message = "The category_id cant be lowwer than 1")
    private Integer category_id;
    @NotNull(message="description is obligatory")
    @NotBlank(message = "description is obligatory")
    private String description;

    private String date;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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
