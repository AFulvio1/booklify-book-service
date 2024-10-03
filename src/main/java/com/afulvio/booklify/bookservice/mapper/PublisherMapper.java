package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.SavePublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PublisherMapper {

    PublisherDTO entityToDTO(PublisherEntity entity);
    
    PublisherEntity requestToEntity(SavePublisherRequest request);

    void updateFromRequest(UpdatePublisherRequest request, @MappingTarget PublisherEntity entity);

}
