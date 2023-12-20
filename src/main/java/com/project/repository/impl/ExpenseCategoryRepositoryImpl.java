package com.project.repository.impl;

import com.project.entity.ExpenseCategory;
import com.project.repository.ExpenseCategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseCategoryRepositoryImpl implements ExpenseCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_EXPENSE_CATEGORY_BY_ID ="SELECT * FROM ExpenseCategory WHERE id=?";
    private static final String GET_ALL_EXPENSE_CATEGORY ="SELECT * FROM ExpenseCategory";
    private static final String INSERT_EXPENSE_CATEGORY="INSERT INTO ExpenseCategory (name) VALUES(?)";
    private static final String UPDATE_EXPENSE_CATEGORY ="UPDATE ExpenseCategory SET name=?= WHERE id=?";
    private static final String DELETE_EXPENSE_CATEGORY ="DELETE FROM ExpenseCategory WHERE id=?";


    public ExpenseCategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Integer insert(ExpenseCategory expenseCategory) {
        return jdbcTemplate.update(INSERT_EXPENSE_CATEGORY,expenseCategory.getName());
    }

    @Override
    public void getCategoryByName(String name) {

    }
}
