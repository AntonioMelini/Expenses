package com.project.controller;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;
    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping("/categoryExpense")
    public void insertCategoryExpense(ExpenseCategoryRequestDto expenseCategoryRequestDto){
        expenseCategoryService.insert(expenseCategoryRequestDto);
    }
}
