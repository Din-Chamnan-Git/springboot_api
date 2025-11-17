package com.learn.pro1.service;

import com.learn.pro1.dto.request.SupplierRequestDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import org.springframework.stereotype.Service;


@Service
public interface SupplierService {

    //create supplier
    SupplierResponseDTO createSupplier(SupplierRequestDTO supplierRequestDTO);

}
