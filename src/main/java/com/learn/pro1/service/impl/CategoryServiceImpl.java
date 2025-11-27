package com.learn.pro1.service.impl;

import com.learn.pro1.dto.request.CategoryRequestDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;
import com.learn.pro1.entity.Category;
import com.learn.pro1.mapper.CategoryMapper;
import com.learn.pro1.repository.CategoryRepository;
import com.learn.pro1.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        // Parent category functionality is currently disabled
        // if(categoryRequestDTO.getParentCategoryId() != null){
        //     Category parent = categoryRepository.findById(categoryRequestDTO.getParentCategoryId())
        //             .orElseThrow(() -> new RuntimeException("Parent Category Not Found"));
        // }

        Category category = categoryMapper.toEntity(categoryRequestDTO);

        categoryRepository.save(category);

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toResponse(categories);
    }



}
