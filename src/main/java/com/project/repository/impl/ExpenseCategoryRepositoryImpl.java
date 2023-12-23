package com.project.repository.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.entity.mapper.ExpenseCategoryMapper;
import com.project.exception.expenseCategory.NoExpenseCategoryFound;
import com.project.repository.ExpenseCategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<ExpenseCategoryRequestDto> getAll() {
        return jdbcTemplate.query(GET_ALL_EXPENSE_CATEGORY,new ExpenseCategoryMapper());
    }

    @Override
    public ExpenseCategoryRequestDto getById(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_EXPENSE_CATEGORY_BY_ID, (resultSet, rowNum) -> {
                ExpenseCategoryRequestDto expenseCategory = new ExpenseCategoryRequestDto();
                expenseCategory.setName(resultSet.getString("name"));
                return expenseCategory;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoExpenseCategoryFound("No ExpenseCategory Found");
        }
    }


}
