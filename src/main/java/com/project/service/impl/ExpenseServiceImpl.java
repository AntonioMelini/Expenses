package com.project.service.impl;

import com.project.dto.request.ExpenseRequestDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;
import com.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }

    @Override
    public void getAllExpense() {

    }

    @Override
    public void getExpenseById() {

    }

    @Override
    public void insertExpense(ExpenseRequestDto expenseRequestDto) {
        expenseRepository.insert(mapExpenseRequestDtoToExpenseDto(expenseRequestDto));



    }

    @Override
    public void updateExpenseById() {

    }

    @Override
    public void deleteExpenseById() {

    }


    public Expense mapExpenseRequestDtoToExpenseDto(ExpenseRequestDto expenseRequestDto){
        Expense expense = new Expense();
        expense.setAmount(expenseRequestDto.getAmount());
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setDate(expenseRequestDto.getDate());
        return expense;
    }
}
