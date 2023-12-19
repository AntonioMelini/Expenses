package com.project.repository;

public interface ExpenseCategoryRepository {
    void insert(ExpenseCategoryDto expenseCategoryDto);
    void getCategoryByName(String name);
}
