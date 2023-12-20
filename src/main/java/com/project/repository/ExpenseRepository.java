package com.project.repository;


import com.project.dto.request.ExpenseRequestDto;
import com.project.entity.Expense;

import java.util.List;


public interface ExpenseRepository {
    Integer insert(Expense expense);
    List<ExpenseRequestDto> getAll();
    ExpenseRequestDto getById(Long  id);
    void updateById(Long id);
    void deleteById(Long id);


}
