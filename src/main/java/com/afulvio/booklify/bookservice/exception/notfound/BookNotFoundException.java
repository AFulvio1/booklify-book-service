package com.afulvio.booklify.bookservice.exception.notfound;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }

}
