package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.SupplierRequestDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.entity.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper {

    public static Supplier toEntity(SupplierRequestDTO dto){

        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setPhone(dto.getPhone());
        supplier.setEmail(dto.getEmail());
        supplier.setContactPerson(dto.getContactPerson());
        supplier.setAddress(dto.getAddress());
        supplier.setIsActive(dto.getIsActive());
        return supplier;
    }


    public static SupplierResponseDTO toResponse(Supplier supplier){
        SupplierResponseDTO dto = new SupplierResponseDTO();

        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setEmail(supplier.getEmail());


        // for product names
//        List<String> productNames = new ArrayList<>();
//
//        supplier.getProducts().forEach(product -> productNames.add(product.getName()));

//        dto.setProducts(productNames);

        return dto;
    }

}
