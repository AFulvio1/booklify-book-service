package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCategoryResponse {

    private CategoryDTO category;

}
