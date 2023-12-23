package com.project.repository;


import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;

import java.util.List;


public interface ExpenseRepository {
    Integer insert(Expense expense);
    List<ExpenseResponseDto> getAll();
    ExpenseResponseDto getById(Integer  id);
    Integer updateById(Integer id, ExpenseRequestDto expenseRequestDto);
    Integer deleteById(Integer id);


}
