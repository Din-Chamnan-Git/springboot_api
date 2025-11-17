package com.learn.pro1.controller;

import com.learn.pro1.dto.request.BrandRequestDTO;
import com.learn.pro1.dto.response.BrandResponeDTO;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    public final BrandService brandService;
    // inject brand service
    public BrandController(BrandService brandService){

        this.brandService = brandService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<BrandResponeDTO>> createBrand(@Valid @RequestBody BrandRequestDTO brandRequestDTO){
        BrandResponeDTO b = brandService.createBrand(brandRequestDTO);

        return ResponseEntity.ok(new ApiResponse<>(true, "Brand Created Successfully", b));

    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<BrandResponeDTO>>> getAllBrands(){
        List<BrandResponeDTO> brands = brandService.getBrandAll();

        return ResponseEntity.ok(new ApiResponse<>(true, "Brands retrieved successfully", brands));
    }



}
