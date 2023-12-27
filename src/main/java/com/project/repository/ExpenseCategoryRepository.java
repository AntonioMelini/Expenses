package com.project.repository;
import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryRepository {
    Integer insert(ExpenseCategory expenseCategory);
    ExpenseCategoryRequestDto getCategoryByName(String name);

    List<ExpenseCategoryRequestDto> getAll();

    ExpenseCategoryRequestDto getById(int id);
}
