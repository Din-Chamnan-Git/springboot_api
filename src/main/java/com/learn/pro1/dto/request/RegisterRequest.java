package com.learn.pro1.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String email;

}
