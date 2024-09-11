package com.afulvio.booklify.bookservice.dto.request;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePublisherRequest {

    private PublisherDTO publisher;

}
