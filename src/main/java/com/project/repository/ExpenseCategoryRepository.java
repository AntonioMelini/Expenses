package com.project.repository;
import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryRepository {
    Integer insert(ExpenseCategory expenseCategory);
   // void getCategoryByName(String name);

    List<ExpenseCategoryRequestDto> getAll();

    ExpenseCategoryRequestDto getById(int id);

    ExpenseCategoryRequestDto getByName(String name);
}
