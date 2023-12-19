package com.project.repository;


import com.project.dto.ExpenseDto;
import java.util.List;

public interface ExpenseRepository {
    void insert(ExpenseDto expenseDto);
    List<ExpenseDto> getAll();
    ExpenseDto getById(Long  id);
    void updateById(Long id);
    void deleteById(Long id);

}
