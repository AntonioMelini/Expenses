package com.project.service.impl;

import com.project.dto.request.UserRequestDto;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String insert(UserRequestDto userRequestDto) {
        Integer rowsAffected = userRepository.insert(userRequestDto);
        if (rowsAffected.equals(0)) return "No se pudo crear el usuario";
        return "Se creo correctamente el usuario";
    }
}
