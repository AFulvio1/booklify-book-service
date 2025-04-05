package com.afulvio.booklify.bookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoryEntity category;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "title2")
    private String title2;

    @Column(name = "title3")
    private String title3;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "volume")
    private String volume;

    @Column(name = "publication_year")
    private String publication_year;

    @Column(name = "language")
    private String language;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher", referencedColumnName = "id")
    private PublisherEntity publisher;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "pages")
    private String pages;

    @Column(name = "image")
    private String image;

    @Column(name = "note")
    private String note;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "tms")
    @UpdateTimestamp
    private LocalDateTime tms;

}
