package com.project.repository.impl;

import com.project.dto.request.UserRequestDto;
import com.project.entity.User;
import com.project.entity.mapper.UserMapper;
import com.project.entity.mapper.UserResponseDtoMapper;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER="INSERT INTO Users (email,name,lastname,password,role) VALUES(?,?,?,?,?)";
    private static final String GET_ALL_USER="SELECT * FROM Users";
    private static final String GET_USER_BY_EMAIL="SELECT * FROM Users WHERE email=?";

    private final JdbcTemplate jdbcTemplate;


@Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }


    @Override
    public Integer insert(User user) {

        //System.out.println(user.getRole().toString().equals("USER"));
       return  jdbcTemplate.update(INSERT_USER,user.getEmail(),user.getName(),user.getLastname(),user.getPassword(),user.getRole().toString());



    }

    @Override
    public List<UserRequestDto> getAll() {
        return jdbcTemplate.query(GET_ALL_USER,new UserResponseDtoMapper());
    }

    @Override
    public User getByEmail(String email) {
        return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL,new UserMapper(),email);
    }
}
