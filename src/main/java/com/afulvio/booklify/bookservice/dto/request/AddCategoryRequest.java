package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    @Valid
    private String name;

}
