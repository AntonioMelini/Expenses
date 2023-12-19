package com.project.repository;
import com.project.dto.ExpenseCategoryDto;

public interface ExpenseCategoryRepository {
    void insert(ExpenseCategoryDto expenseCategoryDto);
    void getCategoryByName(String name);
}
