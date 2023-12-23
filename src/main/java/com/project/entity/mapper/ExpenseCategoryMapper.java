package com.project.entity.mapper;

import com.project.dto.request.ExpenseCategoryRequestDto;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseCategoryMapper implements RowMapper<ExpenseCategoryRequestDto> {

    public ExpenseCategoryRequestDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ExpenseCategoryRequestDto expenseCategory= new ExpenseCategoryRequestDto();
        expenseCategory.setName(resultSet.getString("name"));
        return expenseCategory;
    }
}
