package com.afulvio.booklify.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private CategoryDTO category;
    private String author;
    private String title;
    private String title2;
    private String title3;
    private String subtitle;
    private String volume;
    private String publication_year;
    private String language;
    private String isbn;
    private PublisherDTO publisher;
    private BigDecimal width;
    private BigDecimal length;
    private String pages;
    private String image;
    private String note;
    private BigDecimal price;
    private LocalDateTime tms;

}
