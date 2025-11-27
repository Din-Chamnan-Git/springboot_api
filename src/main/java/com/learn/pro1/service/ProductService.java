package com.learn.pro1.service;

import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    //create product
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    //get all products
    List<ProductResponseDTO> getAllProducts();

}
