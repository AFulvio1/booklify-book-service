package com.afulvio.booklify.bookservice.dto.request;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPublisherRequest {

    @Valid
    private String name;
    @Valid
    private String country;
    private String city;
    private String address;
    private String zip;
    private String website;
    private String contacts;

}
