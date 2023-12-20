package com.project.service;

import com.project.dto.request.ExpenseRequestDto;

public interface ExpenseService {
    void getAllExpense();
     void getExpenseById();
     String insertExpense(ExpenseRequestDto expenseRequestDto);
     void updateExpenseById();
     void deleteExpenseById();

}
