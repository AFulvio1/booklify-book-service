package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePublisherResponse {

    private PublisherDTO publisher;

}
