package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCategoryResponse {

    private CategoryDTO category;
}
