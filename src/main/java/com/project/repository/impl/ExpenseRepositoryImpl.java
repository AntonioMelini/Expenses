package com.project.repository.impl;

import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseCategoryRepository;
import com.project.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final String UPDATE_EXPENSE ="UPDATE Expense SET description=?,amount=?,date=?,category_id=?= WHERE id=?";
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
            System.out.println("ESTO TIENE EL EXPENSE QUE BUSCAMOS: ");
            System.out.println("amount: " + row.get("amount"));
            System.out.println("date: " + row.get("date"));
            System.out.println("description: " + row.get("description"));
            System.out.println("id: " + row.get("id"));
            System.out.println(row.get("category_id"));
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
    public ExpenseResponseDto getById(int id) {
        ExpenseResponseDto expenseResponseDto= jdbcTemplate.queryForObject(GET_EXPENSE_BY_ID,(resultSet,rowNum) ->{
            ExpenseResponseDto dto = new ExpenseResponseDto();
            dto.setAmount(resultSet.getDouble("amount"));
            dto.setDate(resultSet.getString("date"));
            dto.setDescription(resultSet.getString("description"));
            System.out.println("ESTO TIENE EL EXPENSE QUE BUSCAMOS: "+id);
            System.out.println("amount: "+resultSet.getDouble("amount"));
            System.out.println("date: "+resultSet.getString("date"));
            System.out.println("description: "+resultSet.getString("description"));
            System.out.println("category_id: "+resultSet.getInt("category_id"));
            dto.setCategory_name((expenseCategoryRepository.getById( resultSet.getInt("category_id"))).getName());
            System.out.println("ESTO ES EL DTO "+ dto);
            return dto;
        },id);
        return expenseResponseDto;
    }

    @Override
    public void updateById(int id) {

    }

    @Override
    public Integer deleteById(int id) {
        return jdbcTemplate.update(DELETE_EXPENSE,id);
    }
}
