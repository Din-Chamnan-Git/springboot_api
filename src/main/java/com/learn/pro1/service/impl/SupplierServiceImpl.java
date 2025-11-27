package com.learn.pro1.service.impl;

import com.learn.pro1.dto.request.SupplierRequestDTO;
import com.learn.pro1.dto.response.SupplierResponseDTO;
import com.learn.pro1.entity.Supplier;
import com.learn.pro1.mapper.SupplierMapper;
import com.learn.pro1.repository.SupplierRepository;
import com.learn.pro1.service.SupplierService;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }


    @Override
    public SupplierResponseDTO createSupplier(SupplierRequestDTO supplierRequestDTO ) {

        Supplier supplier = supplierMapper.toEntity(supplierRequestDTO);


       supplierRepository.save(supplier);

        return supplierMapper.toResponse(supplier);

    }
}
