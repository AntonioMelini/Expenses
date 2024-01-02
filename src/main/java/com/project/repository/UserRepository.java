package com.project.repository;

import com.project.dto.request.UserRequestDto;
import com.project.entity.User;

import java.util.List;

public interface UserRepository {
    Integer insert(User user);

    List<UserRequestDto> getAll();

    User getByEmail(String email);
}
