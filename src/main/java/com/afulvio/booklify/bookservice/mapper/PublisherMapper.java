package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.AddPublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.entity.PublisherEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO entityToDTO(PublisherEntity entity);

    PublisherEntity dtoToEntity(PublisherDTO dto);

    PublisherEntity requestToEntity(AddPublisherRequest request);

    PublisherEntity requestToEntity(UpdatePublisherRequest request);
}
