package com.learn.pro1.controller;


import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Rescontroller used at the controller layer
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> createProduct(@Valid @RequestBody ProductRequestDTO product){

        ProductResponseDTO pro = productService.createProduct(product);

        ApiResponse<ProductResponseDTO> response = new ApiResponse<>(true, "Product Created Successfully", pro);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id){
//        return productService.getProductById(id).map(product -> ResponseEntity.ok( new ApiResponse<>(true , "Product Found", product))  )
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product Not Found", null)));
//    }
//

//    @GetMapping("/all")
//    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAllProducts(){
//        return ResponseEntity.ok(new ApiResponse<>(true, "Products retrieved successfully", productService.getAllProducts()));
//    }

//
//    // update product by id
//    @PutMapping("/update/{id}")
//    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id ,@Valid @RequestBody Product product){
//        return productService.updateProduct(id , product)
//                .map(up -> ResponseEntity.ok(
//                        new ApiResponse<>(true , "Product Update Success" , up)
//                )).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product Not Found", null)));
//    }
//
//
//    // delete product by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse<Void>> deleteProductById(@PathVariable Long id){
//
//        boolean found = productService.deleteProductById(id);
//
//        if(found){
//            return ResponseEntity.ok(new ApiResponse<>(true, "Product "+ id +" Deleted Successfully", null));
//        }
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product id "+id+" Not Found", null));
//
//    }

}
