package com.project.service;

import com.project.dto.request.ExpenseRequestDto;

public interface ExpenseService {
    void getAllExpense();
     void getExpenseById();
     void insertExpense(ExpenseRequestDto expenseRequestDto);
     void updateExpenseById();
     void deleteExpenseById();

}
