package com.project.entity.mapper;

import com.project.dto.request.UserRequestDto;
import com.project.entity.Role;
import com.project.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user =new User();
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setLastname(rs.getString("lastname"));
        user.setPassword(rs.getString("password"));
        user.setRole(Role.valueOf(rs.getString("role")));
        return user;
    }
}
