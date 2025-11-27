package com.learn.pro1.service;

import com.learn.pro1.dto.request.LoginRequest;
import com.learn.pro1.dto.request.RegisterRequest;
import com.learn.pro1.dto.response.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {


    AuthResponse createUser(RegisterRequest user);

}
