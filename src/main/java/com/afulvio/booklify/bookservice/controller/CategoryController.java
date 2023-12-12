package com.afulvio.booklify.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.dto.CategoryDto;
import com.afulvio.booklify.bookservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@Tag(
        name = "Categories APIs",
        description = "Create Category, Update Category, Get Category, Delete Category"
)
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/get-category/{id}")
    @Operation(summary = "Get Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<CategoryDto> getCategory(
            @PathVariable("id") String id
    ){
        CategoryDto categoryDto = categoryService.getCategoryById(Integer.valueOf(id));
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @PostMapping("/add-category")
    @Operation(summary = "Create a Category")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<CategoryDto> saveCategory(
            @RequestBody CategoryDto categoryDto
    ){
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-category/{id}")
    @Operation(summary = "Delete Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable("id") String id
    ){
        Void deletedCategory = categoryService.deleteCategoryById(Integer.valueOf(id));
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
         this.categoryService = categoryService;
    }
}
