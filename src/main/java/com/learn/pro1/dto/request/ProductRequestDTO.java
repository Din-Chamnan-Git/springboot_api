package com.learn.pro1.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequestDTO {


    private String name;


    private String sku;


    private Double price;


    private String imageUrl;

    private String description;

    private Long categoryId;

    private Long brandId;

    private List<Long> supplierIds;

}
