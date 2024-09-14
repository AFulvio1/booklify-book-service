package com.afulvio.booklify.bookservice.exception.notfound;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
