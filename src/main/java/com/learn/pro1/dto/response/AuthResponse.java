package com.learn.pro1.dto.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String username;
    private String email;
    private String role;

}
