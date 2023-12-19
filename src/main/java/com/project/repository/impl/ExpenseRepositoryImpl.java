package com.project.repository.impl;

import com.project.dto.ExpenseDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {


    @Override
    public void insert(Expense expense) {

    }

    @Override
    public List<ExpenseDto> getAll() {
        return null;
    }

    @Override
    public ExpenseDto getById(Long id) {
        return null;
    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
