package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GetBookResponse> getBook(
            @PathVariable("id") @Valid final Long id
    ){
        GetBookResponse response = bookService.getBookById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all Books")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetBooksResponse> getALlBooks() {
        GetBooksResponse response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Save a Book")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<AddBookResponse> saveBook(
            @RequestBody AddBookRequest request
    ){
        AddBookResponse response = bookService.addBook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteBookResponse> deleteBook(
            @PathVariable("id") @Valid final Long id
    ) {
        DeleteBookResponse response = bookService.deleteBookById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a Book")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdateBookResponse> updateBook(
            @RequestBody UpdateBookRequest request
    ){
        UpdateBookResponse response = bookService.updateBook(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
