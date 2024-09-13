package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePublisherResponse {

    private PublisherDTO publisher;

}
