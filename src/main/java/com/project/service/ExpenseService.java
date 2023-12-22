package com.project.service;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    List<ExpenseResponseDto> getAllExpenses();
     ExpenseResponseDto getExpenseById(Integer id);
     String insertExpense(ExpenseRequestDto expenseRequestDto);
     String updateExpenseById(Integer id,ExpenseRequestDto expenseRequestDto);
     String deleteExpenseById(Integer id);

}
