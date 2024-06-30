package com.afulvio.booklify.bookservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
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
    private String lang;
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
