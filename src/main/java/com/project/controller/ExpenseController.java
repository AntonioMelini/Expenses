package com.project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseController {
    //private ExpenseService expenseService;

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
