package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.AddCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all the Categories")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetCategoriesResponse> getCategories(){
        GetCategoriesResponse response = categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a Category")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<AddCategoryResponse> saveCategory(
            @RequestBody @Valid AddCategoryRequest request,
            UriComponentsBuilder uriBuilder
    ){
        AddCategoryResponse response = categoryService.addCategory(request);
        URI location = uriBuilder.path("/api/books/{id}")
                .buildAndExpand(response.getCategory().getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteCategoryResponse> deleteCategory(
            @PathVariable("id") final Long id
    ){
        DeleteCategoryResponse response = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a Category")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdateCategoryResponse> updateCategory(
            @RequestBody UpdateCategoryRequest request
    ){
        UpdateCategoryResponse response = categoryService.updateCategory(request);
        return ResponseEntity.accepted().body(response);
    }

}
