package com.learn.pro1.service.impl;

import com.learn.pro1.dto.request.LoginRequest;
import com.learn.pro1.dto.request.RegisterRequest;
import com.learn.pro1.dto.response.AuthResponse;
import com.learn.pro1.entity.User;
import com.learn.pro1.mapper.AuthMapper;
import com.learn.pro1.repository.UserRepository;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, AuthMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AuthResponse createUser(RegisterRequest user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return null;

        }

        User u = userMapper.toEntity(user);

        u.setPassword(passwordEncoder.encode(u.getPassword()));

        u.setRole("ROLE_USER");

        return userMapper.toResponse(userRepository.save(u));

    }
}
