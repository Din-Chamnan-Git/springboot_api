package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.LoginRequest;
import com.learn.pro1.dto.request.RegisterRequest;
import com.learn.pro1.dto.response.AuthResponse;
import com.learn.pro1.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    User toEntity(LoginRequest authRequest);

    User toEntity(RegisterRequest registerRequest);


    AuthResponse toResponse(User user);


}
