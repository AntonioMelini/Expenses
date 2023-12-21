package com.project.service;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    List<ExpenseResponseDto> getAllExpenses();
     ExpenseResponseDto getExpenseById(int id);
     String insertExpense(ExpenseRequestDto expenseRequestDto);
     void updateExpenseById();
     void deleteExpenseById();

}
