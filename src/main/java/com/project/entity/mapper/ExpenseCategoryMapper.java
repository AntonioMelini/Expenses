package com.project.entity.mapper;

import com.project.dto.request.ExpenseCategoryRequestDto;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseCategoryMapper implements RowMapper<ExpenseCategoryRequestDto> {

    public ExpenseCategoryRequestDto mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println("ENTRO AL MAPPER");
        ExpenseCategoryRequestDto expenseCategory= new ExpenseCategoryRequestDto();
        System.out.println("CREO EL REQUESTdto");
        expenseCategory.setName(resultSet.getString("name"));
        System.out.println("LE PUSO NOMBRE y DEVUELVe");
        return expenseCategory;
    }
}
