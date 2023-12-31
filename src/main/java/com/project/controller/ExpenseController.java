package com.project.controller;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;
import com.project.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ExpenseResponseDto>>  getAllExpense(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseService.getAllExpenses());
    }
    @GetMapping("/expense/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseService.getExpenseById(id));
    }
    @PostMapping("/expense")
    // En createExpense la category_id la damos por sabida ya que en un futuro se generara un front end con todas las categorias para seleccionarlas al momento de la creacion.
    public ResponseEntity<String> createExpense(@Valid @RequestBody  ExpenseRequestDto expenseRequestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseService.insertExpense(expenseRequestDto));
    }
    @PutMapping("/expense/{id}")
    public ResponseEntity<String> updateExpenseById(@PathVariable Integer id,@Valid @RequestBody ExpenseRequestDto expenseRequestDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseService.updateExpenseById(id,expenseRequestDto));
    }
    @DeleteMapping("/expense/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenseService.deleteExpenseById(id));
    }
}
