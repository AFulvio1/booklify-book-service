package com.afulvio.booklify.bookservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data @Builder
public class PublisherDTO {

    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String zip;
    private String website;
    private String contacts;
    private LocalDateTime tms;

}
