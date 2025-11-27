package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.CategoryRequestDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;
import com.learn.pro1.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Entity -> DTO
    CategoryResponseDTO toResponse(Category category);

    List<CategoryResponseDTO> toResponse(List<Category> categories);

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequestDTO dto);
}

