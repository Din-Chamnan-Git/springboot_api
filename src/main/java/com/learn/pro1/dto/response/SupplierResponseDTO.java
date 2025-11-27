package com.learn.pro1.dto.response;

import lombok.Data;

@Data
public class SupplierResponseDTO {

    private Long id;
    private String name;

    private String contactPerson;
    private String email;
    private String phone;
//    private List<String> products;
}
