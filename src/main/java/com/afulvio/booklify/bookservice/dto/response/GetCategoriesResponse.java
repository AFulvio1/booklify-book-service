package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoriesResponse {

    private List<CategoryDTO> categories;

}
