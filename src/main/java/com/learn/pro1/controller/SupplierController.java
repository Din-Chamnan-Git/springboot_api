package com.learn.pro1.controller;


import com.learn.pro1.dto.request.SupplierRequestDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private final SupplierService supplierService;


    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }



    @PostMapping("/create")
    private ResponseEntity<ApiResponse<SupplierResponseDTO>> createSupplier(@Valid @RequestBody SupplierRequestDTO supplierRequestDTO){

        SupplierResponseDTO sub = supplierService.createSupplier(supplierRequestDTO);

        return ResponseEntity.ok(new ApiResponse<>(true, "Supplier Created Successfully", sub));

    }


}
