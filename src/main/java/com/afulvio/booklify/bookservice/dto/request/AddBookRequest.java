package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {

    private BookDTO book;

}
