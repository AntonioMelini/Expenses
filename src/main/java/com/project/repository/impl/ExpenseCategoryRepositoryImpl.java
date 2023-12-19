package com.project.repository.impl;

import com.project.entity.ExpenseCategory;
import com.project.repository.ExpenseCategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseCategoryRepositoryImpl implements ExpenseCategoryRepository {

    private final JdbcTemplate jdbcTemplate;


    public ExpenseCategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(ExpenseCategory expenseCategory) {

    }

    @Override
    public void getCategoryByName(String name) {

    }
}
