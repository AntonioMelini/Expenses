package com.project.controller;

import com.project.dto.request.UserRequestDto;
import com.project.dto.response.AuthenticationResponse;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/user")
    public List<UserRequestDto> getAllUser(){
        return userService.getAll();
    }

    @GetMapping("/user/{email}")
    public UserRequestDto getUserByEmail(@PathVariable String email){
    return userService.getByEmail(email);
    }
}
