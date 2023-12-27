package com.project.repository.impl;

import com.project.dto.request.UserRequestDto;
import com.project.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER="INSERT INTO User (email,name,lastname,password,role) VALUES(?,?,?,?,?)";



    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insert(UserRequestDto userRequestDto) {
        return jdbcTemplate.update(INSERT_USER,userRequestDto.getEmail(),userRequestDto.getName(),userRequestDto.getLastname(),userRequestDto.getPassword(),userRequestDto.getRole());
    }
}
