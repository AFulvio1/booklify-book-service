package com.afulvio.booklify.bookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_book")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
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
