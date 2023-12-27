package com.project.repository.impl;

import com.project.dto.request.UserRequestDto;
import com.project.entity.mapper.UserMapper;
import com.project.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER="INSERT INTO User (email,name,lastname,password,role) VALUES(?,?,?,?,?)";
    private static final String GET_ALL_USER="SELECT * FROM User";
    private static final String GET_USER_BY_EMAIL="SELECT * FROM User WHERE email=?";

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insert(UserRequestDto userRequestDto) {
        return jdbcTemplate.update(INSERT_USER,userRequestDto.getEmail(),userRequestDto.getName(),userRequestDto.getLastname(),userRequestDto.getPassword(),userRequestDto.getRole());
    }

    @Override
    public List<UserRequestDto> getAll() {
        return jdbcTemplate.query(GET_ALL_USER,new UserMapper());
    }

    @Override
    public UserRequestDto getByEmail(String email) {
        return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL,new Object[] {email},new UserMapper());
    }
}
