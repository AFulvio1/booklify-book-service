package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.AddCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@Tag(
        name = "Categories APIs",
        description = "Create Category, Update Category, Get Category, Delete Category"
)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get/{id}")
    @Operation(summary = "Get Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetCategoryResponse> getCategory(
            @PathVariable("id") final Long id
    ){
        GetCategoryResponse response = categoryService.getCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all the Categories")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetCategoriesResponse> getCategories(){
        GetCategoriesResponse response = categoryService.getAllCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a Category")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<AddCategoryResponse> saveCategory(
            @RequestBody AddCategoryRequest request
    ){
        AddCategoryResponse response = categoryService.addCategory(request.getCategory());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteCategoryResponse> deleteCategory(
            @PathVariable("id") final Long id
    ){
        DeleteCategoryResponse response = categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a Book")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdateCategoryResponse> updateCategory(
            @RequestBody UpdateCategoryRequest request
    ){
        UpdateCategoryResponse response = categoryService.updateCategory(request.getCategory());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
