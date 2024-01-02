package com.project.service.impl;

import com.project.dto.request.AuthRequestDto;
import com.project.dto.request.UserRequestDto;
import com.project.dto.response.AuthenticationResponse;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.repository.UserRepository;
import com.project.security.service.JwtService;
import com.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationResponse authenticate(AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmail(),
                        authRequestDto.getPassword()
                )
        );
        User user = userRepository.getByEmail(authRequestDto.getEmail());
        String jwtToken = jwtService.generateToken(user);
         AuthenticationResponse authenticationResponse=new AuthenticationResponse(jwtToken);
         return authenticationResponse;
    }

    @Override
    public AuthenticationResponse register(UserRequestDto userRequestDto) {
        User user = mapUserRequestDtoToUser(userRequestDto);
        Integer rowsAffected =userRepository.insert(user);
        if (rowsAffected.equals(0)) System.out.println("ERROR");
        String token = jwtService.generateToken( user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
        return authenticationResponse;
    }


    private User mapUserRequestDtoToUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setLastname(userRequestDto.getLastname());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(Role.USER);
        return user;
    }
}
