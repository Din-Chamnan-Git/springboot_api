package com.learn.pro1.dto.response;

import com.learn.pro1.entity.Brand;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;

    private Double price;

    private String categoryName;
//    private List<String> subCategories;

//    private List<SupplierResponseDTO> suppliers;

    private Brand brand;

//    private LocalDateTime createdDate;

}