package com.afulvio.booklify.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.afulvio.booklify.bookservice.dto.BookDto;
import com.afulvio.booklify.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@Tag(
        name = "Books APIs",
        description = "Create Books, Update Books, Get Books, Delete Books"
)
public class BookController {

    private BookService bookService;

    @GetMapping("/get-book/{id}")
    @Operation(summary = "Get Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<BookDto> getBook(
            @PathVariable("id") String id
    ){
        BookDto bookDto = bookService.getBookById(Long.valueOf(id));
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/get-all-books")
    @Operation(summary = "Get all Books")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<List<BookDto>> getALlBooks() {
        List<BookDto> allBooksList = bookService.getAllBooks();
        return new ResponseEntity<>(allBooksList, HttpStatus.OK);
    }

    @PostMapping("/add-book")
    @Operation(summary = "Save a Book")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<BookDto> saveBook(
            @RequestBody BookDto bookDto
    ){
        BookDto savedBook = bookService.addBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book/{id}")
    @Operation(summary = "Delete Book by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<Void> deleteBook(
            @PathVariable("id") String id
    ) {
        Void deletedBook = bookService.deleteBookById(Long.valueOf(id));
        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }


    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
