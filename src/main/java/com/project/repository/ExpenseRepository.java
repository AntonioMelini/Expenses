package com.project.repository;


import com.project.dto.ExpenseDto;
import com.project.entity.Expense;

import java.util.List;


public interface ExpenseRepository {
    Integer insert(Expense expense);
    List<ExpenseDto> getAll();
    ExpenseDto getById(Long  id);
    void updateById(Long id);
    void deleteById(Long id);


}
