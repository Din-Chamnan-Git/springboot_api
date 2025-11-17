package com.learn.pro1.service;


import com.learn.pro1.dto.request.BrandRequestDTO;
import com.learn.pro1.dto.response.BrandResponeDTO;

import java.util.List;

public interface BrandService {

    // create brand
    BrandResponeDTO createBrand(BrandRequestDTO brandRequestDTO);

    List<BrandResponeDTO> getBrandAll();

}
