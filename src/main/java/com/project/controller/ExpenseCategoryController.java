package com.project.controller;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> insertExpenseCategory(@RequestBody ExpenseCategoryRequestDto expenseCategoryRequestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseCategoryService.insert(expenseCategoryRequestDto));

    }
    @GetMapping()
    public ResponseEntity<List<ExpenseCategoryRequestDto>> getAllExpenseCategory(){
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseCategoryService.getAll());
    }


    @GetMapping("/{id}")
    public  ResponseEntity<ExpenseCategoryRequestDto> getExpenseCategoryById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseCategoryService.getById(id));
    }
}
