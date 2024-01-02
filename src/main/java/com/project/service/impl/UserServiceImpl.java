package com.project.service.impl;

import com.project.dto.request.UserRequestDto;
import com.project.entity.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<UserRequestDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserRequestDto getByEmail(String email) {
        UserRequestDto user=mapUserToUserResponseDto(userRepository.getByEmail(email));
        return user;
    }
    public UserRequestDto mapUserToUserResponseDto(User user){
        UserRequestDto userRequestDto=new UserRequestDto();
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setName(user.getName());
        userRequestDto.setLastname(user.getLastname());
        userRequestDto.setPassword(user.getPassword());
        return userRequestDto;
    }
}
