package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface ProductMapper {



    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "brand.name", target = "brand.name")
    ProductResponseDTO toDTO(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "brandId", target = "brand.id")
    Product toEntity(ProductRequestDTO pro);

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "brand.name", target = "brand.name")
    List<ProductResponseDTO> toDTO(List<Product> products);

}
