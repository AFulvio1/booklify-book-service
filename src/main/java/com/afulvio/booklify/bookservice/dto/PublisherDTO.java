package com.afulvio.booklify.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
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
