package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.CategoryRequestDTO;
import com.learn.pro1.dto.response.BrandResponeDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;
import com.learn.pro1.entity.Brand;
import com.learn.pro1.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Entity -> DTO
    CategoryResponseDTO toResponse(Category category);

    // List<Entity> -> List<DTO>
    List<CategoryResponseDTO> toResponse(List<Category> categories);

    // DTO -> Entity
    Category toEntity(CategoryRequestDTO dto, Category parentCategory);
}

