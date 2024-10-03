package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.SaveCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    public ResponseEntity<GetCategoryResponse> get(
            @PathVariable("id") final Long id
    ){
        GetCategoryResponse response = categoryService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all the Categories")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetCategoriesResponse> getAll(){
        GetCategoriesResponse response = categoryService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a Category")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<SaveCategoryResponse> save(
            @RequestBody @Valid SaveCategoryRequest request,
            UriComponentsBuilder uriBuilder
    ){
        SaveCategoryResponse response = categoryService.save(request);
        URI location = uriBuilder.path("/api/books/{id}")
                .buildAndExpand(response.getCategory().getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Category by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteCategoryResponse> delete(
            @PathVariable("id") final Long id
    ){
        DeleteCategoryResponse response = categoryService.deleteById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a Category")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdateCategoryResponse> update(
            @PathVariable @Valid @NotNull final Long id,
            @RequestBody UpdateCategoryRequest request
    ){
        UpdateCategoryResponse response = categoryService.update(id, request);
        return ResponseEntity.accepted().body(response);
    }

}
