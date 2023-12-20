package com.project.controller;

import com.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public void getAllExpense(){}
    @GetMapping("/expense/{id}")
    public void getExpenseById(){}
    @PostMapping("/expense")
    public void createExpense(){}
    @PutMapping("/expense/{id}")
    public void updateExpenseById(){}
    @DeleteMapping("/expense/{id}")
    public void deleteExpenseById(){}
}
