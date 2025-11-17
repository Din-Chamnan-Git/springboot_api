package com.learn.pro1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class SupplierRequestDTO {

    @NotBlank(message = "Supplier name is required")
    private String name;

    private String contactPerson;

    @NotBlank(message = "Supplier email is required")
    private String email;

    @NotBlank(message = "Supplier phone is required")
    private String phone;

    private String address;

    private Boolean isActive = true;

}
