package com.project.repository.impl;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;
import com.project.exception.expense.NoExpenseFound;
import com.project.repository.ExpenseCategoryRepository;
import com.project.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private static final String GET_EXPENSE_BY_ID ="SELECT * FROM Expense WHERE id=?";
    private static final String GET_ALL_EXPENSE ="SELECT * FROM Expense";
    private static final String INSERT_EXPENSE="INSERT INTO Expense (description,amount,date,category_id) VALUES(?,?,?,?)";
    private static final String UPDATE_EXPENSE ="UPDATE Expense SET description=?,amount=?,date=?,category_id=?  WHERE id=?";
    private static final String DELETE_EXPENSE ="DELETE FROM Expense WHERE id=?";

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate, ExpenseCategoryRepository expenseCategoryRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public Integer insert(Expense expense) {
        return jdbcTemplate.update(INSERT_EXPENSE,expense.getDescription(),expense.getAmount(),expense.getDate(),expense.getCategory_id());
        
    }
    @Override
    public List<ExpenseResponseDto> getAll() {
        List<ExpenseResponseDto> expenses = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_ALL_EXPENSE);
        for (Map row : rows) {
            ExpenseResponseDto dto = new ExpenseResponseDto();
            dto.setAmount((Double) row.get("amount"));
            dto.setDate((String) row.get("date"));
            dto.setDescription((String) row.get("description"));
            dto.setCategory_name(expenseCategoryRepository.getById((int) row.get("category_id")).getName());
            expenses.add(dto);
        }
        return expenses;
    }

/*
    @Override
    public List<ExpenseResponseDto> getAll() {
        List<ExpenseResponseDto> expenses= jdbcTemplate.queryForObject(GET_ALL_EXPENSE,(resultSet,rowNum) ->{
          while (resultSet.next()){
              List<ExpenseResponseDto> expensesv1=new ArrayList<>();
              ExpenseResponseDto dto = new ExpenseResponseDto();
              dto.setAmount(resultSet.getDouble("amount"));
              dto.setDate(resultSet.getString("date"));
              dto.setDescription(resultSet.getString("description"));
              dto.setCategory_name(expenseCategoryRepository.getById((long) resultSet.getInt("id")).getName());
              expensesv1.add(dto);
          }

        });
        return expenses;
    }
*/
    @Override
    public ExpenseResponseDto getById(Integer id) {
        try {
            ExpenseResponseDto expenseResponseDto= jdbcTemplate.queryForObject(GET_EXPENSE_BY_ID,(resultSet,rowNum) ->{
                ExpenseResponseDto dto = new ExpenseResponseDto();
                dto.setAmount(resultSet.getDouble("amount"));
                dto.setDate(resultSet.getString("date"));
                dto.setDescription(resultSet.getString("description"));
                dto.setCategory_name((expenseCategoryRepository.getById( resultSet.getInt("category_id"))).getName());
                return dto;
            },id);
            return expenseResponseDto;
        }catch (EmptyResultDataAccessException e){
            throw  new NoExpenseFound("No Expense found");
        }

    }
    public ExpenseRequestDto getByIdExpenseResponseDto(Integer id) {
       try {
           ExpenseRequestDto expenseResponseDto= jdbcTemplate.queryForObject(GET_EXPENSE_BY_ID,(resultSet,rowNum) ->{
               ExpenseRequestDto dto = new ExpenseRequestDto();
               dto.setAmount(resultSet.getDouble("amount"));
               dto.setDate(resultSet.getString("date"));
               dto.setDescription(resultSet.getString("description"));
               dto.setCategory_id(resultSet.getInt("category_id"));
               return dto;
           },id);
           return expenseResponseDto;
       }catch (EmptyResultDataAccessException e){
           throw  new NoExpenseFound("No Expense found");
       }

    }

    @Override
    public Integer updateById(Integer id, ExpenseRequestDto expenseRequestDto) {
        try {
            ExpenseRequestDto oldExpense = getByIdExpenseResponseDto(id);
            return jdbcTemplate.update(UPDATE_EXPENSE, expenseRequestDto.getDescription() == null ? oldExpense.getDescription() : expenseRequestDto.getDescription(), expenseRequestDto.getAmount() != null ? expenseRequestDto.getAmount() : oldExpense.getAmount(), expenseRequestDto.getDate() != null ? expenseRequestDto.getDate() : oldExpense.getDate(), expenseRequestDto.getCategory_id() != null ? expenseRequestDto.getCategory_id() : oldExpense.getCategory_id(), id);

        }catch (EmptyResultDataAccessException e){
            throw  new NoExpenseFound("No Expense found");
        }
    }

    @Override
    public Integer deleteById(Integer id) {
        try {
            return jdbcTemplate.update(DELETE_EXPENSE,id);
        }catch (EmptyResultDataAccessException e){
            throw  new NoExpenseFound("No Expense found");
        }

    }
}
