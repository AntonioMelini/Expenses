package com.project.repository.impl;

import com.project.dto.request.ExpenseRequestDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private static final String GET_EXPENSE_BY_ID ="SELECT * FROM Expense WHERE id=?";
    private static final String GET_ALL_EXPENSE ="SELECT * FROM Expense";
    private static final String INSERT_EXPENSE="INSERT INTO Expense (description,amount,date,category_id) VALUES(?,?,?,?)";
    private static final String UPDATE_EXPENSE ="UPDATE Expense SET description=?,amount=?,date=?,category_id=?= WHERE id=?";
    private static final String DELETE_EXPENSE ="DELETE FROM Expense WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insert(Expense expense) {
        return jdbcTemplate.update(INSERT_EXPENSE,expense.getDescription(),expense.getAmount(),expense.getDate(),expense.getCategory_id());
        
    }

    @Override
    public List<ExpenseRequestDto> getAll() {
        return null;
    }

    @Override
    public ExpenseRequestDto getById(Long id) {
        return null;
    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
