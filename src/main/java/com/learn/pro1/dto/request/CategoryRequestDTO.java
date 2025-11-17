package com.learn.pro1.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDTO {

    @NotBlank(message = "Category name should not be blank")
//    @Size(min = 3, max = 20 , message = "Category name should be between 3 and 20 characters")
    private String name;

    @Size( max = 255 , message = "Category description should be between 10 and 255 characters")
    private String description;

    private Long parentCategoryId;


}
