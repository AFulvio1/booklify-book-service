package com.afulvio.booklify.bookservice.exception.notfound;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

}
