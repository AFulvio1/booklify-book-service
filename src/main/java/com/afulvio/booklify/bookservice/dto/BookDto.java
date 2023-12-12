package com.afulvio.booklify.bookservice.dto;

import com.afulvio.booklify.bookservice.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BookDto {
    private Long id;
    private Category category;
    private String author;
    private String title;
    private String subtitle;
    private String volume;
    private Integer yearOfPublication;
    private String publishingHouse;
    private String placeOfPublication;
    private String isbn;
    private BigDecimal price;
    private String note;
    private String imageName;
}
