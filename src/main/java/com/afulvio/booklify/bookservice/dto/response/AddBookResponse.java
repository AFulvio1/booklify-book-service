package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddBookResponse {

    private BookDTO bookDTO;
}
