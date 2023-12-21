package com.project.repository;


import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;

import java.util.List;


public interface ExpenseRepository {
    Integer insert(Expense expense);
    List<ExpenseResponseDto> getAll();
    ExpenseResponseDto getById(int  id);
    void updateById(int id);
    void deleteById(int id);


}
