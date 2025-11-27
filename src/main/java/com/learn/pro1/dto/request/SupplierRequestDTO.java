package com.learn.pro1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class SupplierRequestDTO {

    @NotBlank(message = "Supplier name is required")
    private String name;

    private String contactPerson;

    @NotBlank(message = "Supplier email is required")
    @Email(message = "Please enter a valid email format")
    private String email;

    @NotBlank(message = "Supplier phone is required")
    private String phone;

    private String address;

    private Boolean isActive = true;

}
