package com.learn.pro1.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoryResponseDTO {


    private Long id;
    private String name;
    private String description;
    private Boolean isActive;


    private Long parentCategoryId;
    private String parentCategoryName;

    private List<String> subCategories;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
