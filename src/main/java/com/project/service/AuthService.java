package com.project.service;

import com.project.dto.request.AuthRequestDto;
import com.project.dto.request.UserRequestDto;
import com.project.dto.response.AuthenticationResponse;

import java.net.URI;


public interface AuthService {
    AuthenticationResponse authenticate(AuthRequestDto authRequestDto);

    AuthenticationResponse register(UserRequestDto userRequestDto);
}
