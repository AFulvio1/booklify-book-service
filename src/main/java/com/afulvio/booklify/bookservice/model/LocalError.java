package com.afulvio.booklify.bookservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocalError {

    E001("Error", "Error"),
    E010("it was not possible to recover the book", ""),
    E011("it was not possible to recover the book for update", ""),
    E012("it was not possible to recover the category", ""),
    E013("it was not possible to recover the category for update", ""),
    E014("it was not possible to recover the publisher", ""),
    E015("it was not possible to recover the publisher for update", "");

    private final String message;
    private final String details;

}
