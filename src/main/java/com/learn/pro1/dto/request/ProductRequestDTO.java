package com.learn.pro1.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequestDTO {

    @NotNull(message = "Product name is required")
    @Size(min = 3, max = 255, message = "Product name must be between 3 and 255 characters")
    private String name;

    private String sku;


    private Double price;


    private String imageUrl;

    private String description;

    private Long categoryId;

    private Long brandId;


//    private List<Long> supplierIds;

}
