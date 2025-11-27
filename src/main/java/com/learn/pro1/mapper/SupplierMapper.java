package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.SupplierRequestDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {


    Supplier toEntity(SupplierRequestDTO dto);


    SupplierResponseDTO toResponse(Supplier supplier);


}
