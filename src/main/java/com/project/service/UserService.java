package com.project.service;

import com.project.dto.request.UserRequestDto;

import java.util.List;

public interface UserService {

    List<UserRequestDto> getAll();

    UserRequestDto getByEmail(String email);
}
