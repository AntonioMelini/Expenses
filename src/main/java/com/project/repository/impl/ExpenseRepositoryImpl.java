package com.project.repository.impl;

import com.project.dto.ExpenseDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private static final String GET_EXPENSE_BY_ID ="SELECT * FROM expense WHERE id=?";
    private static final String GET_ALL_EXPENSE ="SELECT * FROM expense";
    private static final String INSERT_EXPENSE="INSERT INTO expense (description,amount,date,categoryId) VALUES(?,?,?,?)";
    private static final String UPDATE_EXPENSE ="UPDATE expense description=?,amount=?,date=?,categoryId=?= WHERE id=?";
    private static final String DELETE_EXPENSE ="DELETE FROM expense WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insert(Expense expense) {
        return jdbcTemplate.update(INSERT_EXPENSE,expense.getDescription(),expense.getAmount(),expense.getDate(),expense.getCategoryId());
        
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
