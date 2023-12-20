package com.project.controller;

import com.project.dto.request.ExpenseRequestDto;
import com.project.entity.Expense;
import com.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<ExpenseRequestDto> getAllExpense(){
        return expenseService.getAllExpenses();
    }
    @GetMapping("/expense/{id}")
    public void getExpenseById(){}
    @PostMapping("/expense")
    public String createExpense(@RequestBody ExpenseRequestDto expenseRequestDto){
        return expenseService.insertExpense(expenseRequestDto);
    }
    @PutMapping("/expense/{id}")
    public void updateExpenseById(){}
    @DeleteMapping("/expense/{id}")
    public void deleteExpenseById(){}
}
