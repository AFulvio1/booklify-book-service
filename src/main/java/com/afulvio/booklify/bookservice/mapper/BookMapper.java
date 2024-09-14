package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO entityToDTO(BookEntity bookEntity);

    BookEntity dtoToEntity(BookDTO bookDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tms", ignore = true)
    BookEntity requestToEntity(AddBookRequest request);

    @Mapping(target = "tms", ignore = true)
    BookEntity requestToEntity(UpdateBookRequest request);

}
