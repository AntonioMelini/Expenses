package com.project.service;

import com.project.dto.request.UserRequestDto;

import java.util.List;

public interface UserService {
    String insert(UserRequestDto userRequestDto);

    List<UserRequestDto> getAll();

    UserRequestDto getByEmail(String email);
}
