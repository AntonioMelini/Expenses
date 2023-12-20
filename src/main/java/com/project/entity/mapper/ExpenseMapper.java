package com.project.entity.mapper;

import com.project.dto.request.ExpenseRequestDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements RowMapper<ExpenseRequestDto> {
    @Override
    public ExpenseRequestDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ExpenseRequestDto expense = new ExpenseRequestDto();
        expense.setDate(resultSet.getString("date"));
        expense.setAmount(resultSet.getDouble("amount"));
        expense.setDescription(resultSet.getString("description"));
        expense.setCategory_id((long) resultSet.getInt("category_id"));
        return expense;

    }
}
