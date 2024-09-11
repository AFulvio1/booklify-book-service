package com.afulvio.booklify.bookservice.dto.response;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetPublishersResponse {

    private List<PublisherDTO> publishers;

}
