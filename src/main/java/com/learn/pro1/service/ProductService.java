package com.learn.pro1.service;

import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;
import com.learn.pro1.entity.Product;
import com.learn.pro1.repository.ProductRepository;
import com.learn.pro1.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    //create product
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    //get all products
//    List<ProductResponseDTO> getAllProducts();

}
