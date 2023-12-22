package com.project.service.impl;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;
import com.project.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }

    @Override
    public List<ExpenseResponseDto> getAllExpenses() {

        return expenseRepository.getAll();
    }

    @Override
    public ExpenseResponseDto getExpenseById(int id) {
        return expenseRepository.getById(id);
    }

    @Override
    public String insertExpense(ExpenseRequestDto expenseRequestDto) {
       Integer rowsAffected= expenseRepository.insert(mapExpenseRequestDtoToExpenseDto(expenseRequestDto));
        if(rowsAffected.equals(0)) return "No se agrego nada";
        return "Se agrego correctamente el gasto";
    }

    @Override
    public void updateExpenseById() {

    }

    @Override
    public String deleteExpenseById(int id) {
        Integer rowsAffected= expenseRepository.deleteById(id);
        if (rowsAffected.equals(0)) return "NO se pudo eliminar nada";
        return  "Se elimino perfectamente";
    }





    public Expense mapExpenseRequestDtoToExpenseDto(ExpenseRequestDto expenseRequestDto){
        Expense expense = new Expense();
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setAmount(expenseRequestDto.getAmount());
        expense.setDate(String.valueOf(LocalDateTime.now(ZoneId.of("GMT-3")).withNano(0)));
        expense.setCategory_id(expenseRequestDto.getCategory_id());
        return expense;
    }
}
