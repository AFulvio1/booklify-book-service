package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.response.AddBookResponse;
import com.afulvio.booklify.bookservice.dto.response.DeleteBookResponse;
import com.afulvio.booklify.bookservice.dto.response.GetBookResponse;
import com.afulvio.booklify.bookservice.dto.response.GetBooksResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/get-book/{id}")
    @Operation(summary = "Get Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetBookResponse> getBook(
            @PathVariable("id") Long id
    ){
        GetBookResponse response = bookService.getBookById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all-books")
    @Operation(summary = "Get all Books")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetBooksResponse> getALlBooks() {
        GetBooksResponse response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add-book")
    @Operation(summary = "Save a Book")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<AddBookResponse> saveBook(
            @RequestBody AddBookRequest request
    ){
        AddBookResponse response = bookService.addBook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book/{id}")
    @Operation(summary = "Delete Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeleteBookResponse> deleteBook(
            @PathVariable("id") Long id
    ) {
        DeleteBookResponse response = bookService.deleteBookById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
