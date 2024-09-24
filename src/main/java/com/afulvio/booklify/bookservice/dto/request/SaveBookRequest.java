package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRequest {

    @Valid @NotNull
    private CategoryDTO category;
    @Valid @NotEmpty
    private String author;
    @Valid @NotEmpty
    private String title;
    private String title2;
    private String title3;
    private String subtitle;
    private String volume;
    private String publication_year;
    private String lang;
    private String isbn;
    @Valid @NotNull
    private PublisherDTO publisher;
    private BigDecimal width;
    private BigDecimal length;
    private String pages;
    private String image;
    private String note;
    private BigDecimal price;

}
