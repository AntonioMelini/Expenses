package com.project.repository;
import com.project.entity.ExpenseCategory;

public interface ExpenseCategoryRepository {
    void insert(ExpenseCategory expenseCategory);
    void getCategoryByName(String name);
}
