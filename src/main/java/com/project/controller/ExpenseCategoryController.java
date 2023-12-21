package com.project.controller;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/v1/expenseCategory")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;
    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping()
    public String insertExpenseCategory(@RequestBody ExpenseCategoryRequestDto expenseCategoryRequestDto){
        return expenseCategoryService.insert(expenseCategoryRequestDto);

    }
    @GetMapping()
    public List<ExpenseCategoryRequestDto> getAllExpenseCategory(){
        return expenseCategoryService.getAll();
    }


    @GetMapping("/{id}")
    public  ExpenseCategoryRequestDto getExpenseCategoryById(@PathVariable int id){
        return expenseCategoryService.getById(id);
    }
}
