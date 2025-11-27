package com.learn.pro1.controller;

import com.learn.pro1.dto.request.CategoryRequestDTO;
import com.learn.pro1.dto.response.CategoryResponseDTO;
import com.learn.pro1.response.ApiResponse;
import com.learn.pro1.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //create category
    @PostMapping("/create")
    private ResponseEntity<ApiResponse<CategoryResponseDTO>> createCategory(@Valid @RequestBody CategoryRequestDTO requestDTO){
        CategoryResponseDTO cat = categoryService.createCategory(requestDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, "Category Created Successfully", cat));

    }


    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getAllCategories(){
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse<>(true, "Categories retrieved successfully", categories));
    }
//
//
//    // get by id
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<CategoryResponseDTO>> getCategorybyID(@PathVariable Long id){
//
//        CategoryResponseDTO category = categoryService.getCategorybyID(id);
//
//        if(category != null){
//            return ResponseEntity.ok(new ApiResponse<>(true, "Category Found", category));
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Category Not Found", null));
//    }



}
