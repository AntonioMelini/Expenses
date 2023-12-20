package com.project.service;

import com.project.dto.request.ExpenseRequestDto;

import java.util.List;

public interface ExpenseService {
    List<ExpenseRequestDto> getAllExpenses();
     void getExpenseById();
     String insertExpense(ExpenseRequestDto expenseRequestDto);
     void updateExpenseById();
     void deleteExpenseById();

}
