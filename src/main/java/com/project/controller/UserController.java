package com.project.controller;

import com.project.dto.request.UserRequestDto;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/user")
    public String createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.insert(userRequestDto);
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
