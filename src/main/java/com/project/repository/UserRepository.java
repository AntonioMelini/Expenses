package com.project.repository;

import com.project.dto.request.UserRequestDto;

import java.util.List;

public interface UserRepository {
    Integer insert(UserRequestDto userRequestDto);

    List<UserRequestDto> getAll();

    UserRequestDto getByEmail(String email);
}
