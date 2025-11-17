package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.entity.Category;
import com.learn.pro1.entity.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {



    public static ProductResponseDTO toDTO(Product product){ // toDTO is conversion method from entity to dto
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCreatedDate(product.getCreatedAt());
        dto.setCategoryName(product.getCategory().getName());

//        dto.setSubCategories(product.getCategory().getSubCategories().stream().map(Category::getName).toList());

//        if (product.getCategory() != null) {
//            CategoryResponseDTO catDto = new CategoryResponseDTO();
//            catDto.setId(product.getCategory().getId());
//            catDto.setName(product.getCategory().getName());
//            catDto.setDescription(product.getCategory().getDescription());
//            catDto.setIsActive(product.getCategory().isActive());
////            catDto.setCreatedAt(product.getCategory().getCreatedAt());
////            catDto.setUpdatedAt(product.getCategory().getUpdatedAt());
//            dto.
//        }
        if(product.getSuppliers() != null){
             List<SupplierResponseDTO> supplierDtos = product.getSuppliers()
                     .stream().map( s -> {
                         SupplierResponseDTO supplier = new SupplierResponseDTO();
                         supplier.setId(s.getId());
                         supplier.setName(s.getName());
                         supplier.setEmail(s.getEmail());
                         return supplier;
                     } ).collect(Collectors.toList());
             dto.setSuppliers(supplierDtos);
        }

        if(product.getBrand() != null){
            Long brandId = product.getBrand().getId();

            dto.setBrandId(brandId);

        }

        return dto;
    }

    public static Product toEntity(ProductRequestDTO pro){ // toEntity is conversion method from dto to entity

        Product product = new Product();
        product.setName(pro.getName());
        product.setDescription(pro.getDescription());
        product.setPrice(pro.getPrice());
        return product;
    }


}
