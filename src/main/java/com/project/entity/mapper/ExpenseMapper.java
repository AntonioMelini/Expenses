package com.project.entity.mapper;

import com.project.dto.response.ExpenseResponseDto;
import com.project.repository.ExpenseCategoryRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExpenseMapper implements RowMapper<ExpenseResponseDto> {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseMapper(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }



    @Override
    public ExpenseResponseDto mapRow(ResultSet rs, int arg1) throws SQLException {



            ExpenseResponseDto expense = new ExpenseResponseDto();
            expense.setDate(rs.getString("date"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setDescription(rs.getString("description"));
            System.out.println("hasta aca todo bien ////");
            expense.setCategory_name((expenseCategoryRepository.getById( rs.getInt("id")).getName()));
            System.out.println("NO DEBERIA LLEGAR ////");
            return expense;

    }
}
