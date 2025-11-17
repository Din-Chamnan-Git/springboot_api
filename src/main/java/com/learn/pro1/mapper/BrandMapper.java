package com.learn.pro1.mapper;

import com.learn.pro1.dto.request.BrandRequestDTO;
import com.learn.pro1.dto.response.BrandResponeDTO;
import com.learn.pro1.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {


    BrandResponeDTO toResponse(Brand brand);

    Brand toEntity(BrandRequestDTO brandRequestDTO);

    List<BrandResponeDTO> toResponse(List<Brand> brands);

}
