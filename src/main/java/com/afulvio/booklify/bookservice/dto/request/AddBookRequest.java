package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class AddBookRequest {

    private BookDTO bookDTO;

}
