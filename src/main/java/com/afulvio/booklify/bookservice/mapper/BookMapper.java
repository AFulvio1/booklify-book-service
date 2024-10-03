package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    BookDTO entityToDTO(BookEntity bookEntity);

    BookEntity requestToEntity(SaveBookRequest request);

    void updateFromRequest(UpdateBookRequest request, @MappingTarget BookEntity entity);

}
