package com.project.repository.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.entity.mapper.ExpenseCategoryMapper;
import com.project.repository.ExpenseCategoryRepository;
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
        System.out.println("LLEGO A ExpenseCategoryRequestDto en repository: "+id);
        /*
        return jdbcTemplate.queryForObject(GET_EXPENSE_CATEGORY_BY_ID,new Object[] {id},new ExpenseCategoryMapper());

         */
        return jdbcTemplate.queryForObject(GET_EXPENSE_CATEGORY_BY_ID,(resultSet, rowNum) ->{
            System.out.println("ENTRO AL MAPPER");
            ExpenseCategoryRequestDto expenseCategory= new ExpenseCategoryRequestDto();
            System.out.println("CREO EL REQUESTdto");
            expenseCategory.setName(resultSet.getString("name"));
            System.out.println("LE PUSO NOMBRE y DEVUELVe");
            return expenseCategory;
        },id );
    }
}
