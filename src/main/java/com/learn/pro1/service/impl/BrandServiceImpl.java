package com.learn.pro1.service.impl;

import com.learn.pro1.dto.request.BrandRequestDTO;
import com.learn.pro1.dto.response.BrandResponeDTO;
import com.learn.pro1.entity.Brand;
import com.learn.pro1.mapper.BrandMapper;
import com.learn.pro1.repository.BrandRepository;
import com.learn.pro1.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandMapper brandMapper, BrandRepository brandRepository) {
        this.brandMapper = brandMapper;
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandResponeDTO createBrand(BrandRequestDTO brandRequestDTO) {

        Brand brand = brandMapper.toEntity(brandRequestDTO);

        brandRepository.save(brand);

        return brandMapper.toResponse(brand);

    }


    @Override
    public List<BrandResponeDTO> getBrandAll(){
        List<Brand> b = brandRepository.findAll();

        return brandMapper.toResponse(b);

    }


}
