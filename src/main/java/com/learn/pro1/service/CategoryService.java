package com.learn.pro1.service;

import com.learn.pro1.dto.request.CategoryRequestDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    //create category
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    //get all categories
    List<CategoryResponseDTO> getAllCategories();


}
