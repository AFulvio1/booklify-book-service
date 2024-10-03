package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.SaveBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/books")
@Tag(
        name = "Books APIs",
        description = "Create Books, Update Books, Get Books, Delete Books"
)
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get/{id}")
    @Operation(summary = "Get Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetBookResponse> get(
            @PathVariable("id") final Long id
    ){
        GetBookResponse response = bookService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all Books")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetBooksResponse> getALl() {
        GetBooksResponse response = bookService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Operation(summary = "Save a Book")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<SaveBookResponse> save(
            @RequestBody @Valid SaveBookRequest request,
            UriComponentsBuilder uriBuilder
    ){
        SaveBookResponse response = bookService.save(request);
        URI location = uriBuilder.path("/api/books/{id}")
                .buildAndExpand(response.getBook().getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteBookResponse> delete(
            @PathVariable("id") @Valid final Long id
    ) {
        DeleteBookResponse response = bookService.deleteById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a Book")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdateBookResponse> update(
            @PathVariable @NotNull final Long id,
            @RequestBody UpdateBookRequest request
    ){
        UpdateBookResponse response = bookService.update(id, request);
        return ResponseEntity.accepted().body(response);
    }

}
