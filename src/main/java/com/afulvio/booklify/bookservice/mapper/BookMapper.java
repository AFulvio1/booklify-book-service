package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO entityToDTO(BookEntity bookEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tms", ignore = true)
    BookEntity requestToEntity(SaveBookRequest request);

    @Mapping(target = "tms", ignore = true)
    BookEntity requestToEntity(UpdateBookRequest request);

}
