package com.project.repository;
import com.project.entity.ExpenseCategory;

public interface ExpenseCategoryRepository {
    Integer insert(ExpenseCategory expenseCategory);
    void getCategoryByName(String name);
}
