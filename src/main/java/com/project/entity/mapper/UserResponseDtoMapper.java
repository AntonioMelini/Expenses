package com.project.entity.mapper;

import com.project.dto.request.UserRequestDto;
import com.project.entity.User;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResponseDtoMapper implements RowMapper<UserRequestDto> {
    @Override
    public UserRequestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserRequestDto user =new UserRequestDto();
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setLastname(rs.getString("lastname"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
