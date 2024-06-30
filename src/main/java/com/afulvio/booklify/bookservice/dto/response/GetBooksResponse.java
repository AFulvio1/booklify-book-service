package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetBooksResponse {

    private List<BookDTO> books;

}
