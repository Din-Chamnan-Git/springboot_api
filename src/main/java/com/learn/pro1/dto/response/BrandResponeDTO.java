package com.learn.pro1.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandResponeDTO {

    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private String logoUrl;


    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
