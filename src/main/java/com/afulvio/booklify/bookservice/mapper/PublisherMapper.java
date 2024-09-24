package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.SavePublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO entityToDTO(PublisherEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    @Mapping(target = "tms", ignore = true)
    PublisherEntity requestToEntity(SavePublisherRequest request);

    @Mapping(target = "books", ignore = true)
    @Mapping(target = "tms", ignore = true)
    PublisherEntity requestToEntity(UpdatePublisherRequest request);
}
