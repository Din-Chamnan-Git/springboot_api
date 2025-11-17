package com.learn.pro1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandRequestDTO {

    @NotBlank(message = "Brand name is required")
    private String name;

    private String description;

    private Boolean isActive = true;

    private String logoUrl;

}
