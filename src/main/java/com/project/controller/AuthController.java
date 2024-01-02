package com.project.controller;

import com.project.dto.request.AuthRequestDto;
import com.project.dto.request.UserRequestDto;
import com.project.dto.response.AuthenticationResponse;
import com.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthRequestDto authRequestDto){
        return ResponseEntity.ok(authService.authenticate(authRequestDto));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.register(userRequestDto));
    }
}
