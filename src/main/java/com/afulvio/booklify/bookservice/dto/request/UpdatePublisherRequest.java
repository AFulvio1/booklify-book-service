package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePublisherRequest {

    @Valid
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String zip;
    private String website;
    private String contacts;

}
