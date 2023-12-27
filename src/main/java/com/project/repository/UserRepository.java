package com.project.repository;

import com.project.dto.request.UserRequestDto;

public interface UserRepository {
    Integer insert(UserRequestDto userRequestDto);
}
