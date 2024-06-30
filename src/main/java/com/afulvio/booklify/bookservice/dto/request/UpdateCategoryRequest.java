package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.Data;

@Data
public class UpdateCategoryRequest {

    private CategoryDTO category;
}
