package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    private CategoryDTO category;

}
