package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCategoriesResponse {

    private List<CategoryDTO> categorie;

}
