package com.project.controller;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController()
@RequestMapping(value = "/api/v1/categoryExpense")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;
    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping()
    public String insertCategoryExpense(@RequestBody ExpenseCategoryRequestDto expenseCategoryRequestDto){
        return expenseCategoryService.insert(expenseCategoryRequestDto);

    }
}
