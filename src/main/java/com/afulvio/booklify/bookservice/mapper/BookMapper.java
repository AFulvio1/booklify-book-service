package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity dtoToEntity(BookDTO bookDto);

    BookDTO entityToDTO(BookEntity bookEntity);

    BookEntity requestToEntity(AddBookRequest request);

    BookEntity requestToEntity(UpdateBookRequest request);
}
