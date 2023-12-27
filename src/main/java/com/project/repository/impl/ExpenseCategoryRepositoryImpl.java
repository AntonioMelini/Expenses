package com.project.repository.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.entity.mapper.ExpenseCategoryMapper;
import com.project.exception.expenseCategory.ExpenseCategoryAlreadyCraeted;
import com.project.exception.expenseCategory.NoExpenseCategoryFound;
import com.project.repository.ExpenseCategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExpenseCategoryRepositoryImpl implements ExpenseCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_EXPENSE_CATEGORY_BY_ID ="SELECT * FROM ExpenseCategory WHERE id=?";
    private static final String GET_EXPENSE_CATEGORY_BY_NAME ="SELECT * FROM ExpenseCategory WHERE name=?";
    private static final String GET_ALL_EXPENSE_CATEGORY ="SELECT * FROM ExpenseCategory";
    private static final String INSERT_EXPENSE_CATEGORY="INSERT INTO ExpenseCategory (name) VALUES(?)";





    public ExpenseCategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override

    public Integer insert(ExpenseCategory expenseCategory) {

        List<ExpenseCategoryRequestDto> categories= getAll();
        System.out.println("1) "+categories.size());
        List<ExpenseCategoryRequestDto> filtered= categories.stream().filter(category -> category.getName().equals(expenseCategory.getName())).collect(Collectors.toList());
        System.out.println("2)"+filtered.size());

        if (filtered.isEmpty()) return jdbcTemplate.update(INSERT_EXPENSE_CATEGORY,expenseCategory.getName());

        throw new ExpenseCategoryAlreadyCraeted("ExpenseCategory '"+expenseCategory.getName()+"' already exist");

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

    @Override
    public ExpenseCategoryRequestDto getByName(String name) {
        try {
            return jdbcTemplate.queryForObject(GET_EXPENSE_CATEGORY_BY_NAME,new Object[] {name}, new ExpenseCategoryMapper());

        }catch (EmptyResultDataAccessException e){
            throw new NoExpenseCategoryFound("No ExpenseCategory Found");
        }
    }


}
