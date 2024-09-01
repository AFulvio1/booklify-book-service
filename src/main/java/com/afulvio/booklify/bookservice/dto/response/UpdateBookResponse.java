package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  UpdateBookResponse {

    private BookDTO book;

}
