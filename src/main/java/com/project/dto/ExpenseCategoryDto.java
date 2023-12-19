package com.project.dto;

public class ExpenseCategoryDto {
    private String name;

    public ExpenseCategoryDto(String name) {
        this.name = name;
    }

    public ExpenseCategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
