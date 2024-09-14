package com.afulvio.booklify.bookservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocalError {

    E001("001", "Error", "Error"),
    E010("010", "it was not possible to recover the book", ""),
    E011("011", "it was not possible to recover the book for update", ""),
    E012("012", "it was not possible to recover the category", ""),
    E013("013", "it was not possible to recover the category for update", ""),
    E014("014", "it was not possible to recover the publisher", ""),
    E015("015", "it was not possible to recover the publisher for update", "");

    private final String code;
    private final String message;
    private final String details;

}
