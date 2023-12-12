package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDto;
import com.afulvio.booklify.bookservice.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "subtitle", target = "subtitle")
    @Mapping(source = "volume", target = "volume")
    @Mapping(source = "yearOfPublication", target = "yearOfPublication")
    @Mapping(source = "publishingHouse", target = "publishingHouse")
    @Mapping(source = "placeOfPublication", target = "placeOfPublication")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "note", target = "note")
    @Mapping(source = "imageName", target = "imageName")
    Book mapBookDtoToBook(BookDto bookDto);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "subtitle", target = "subtitle")
    @Mapping(source = "volume", target = "volume")
    @Mapping(source = "yearOfPublication", target = "yearOfPublication")
    @Mapping(source = "publishingHouse", target = "publishingHouse")
    @Mapping(source = "placeOfPublication", target = "placeOfPublication")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "note", target = "note")
    @Mapping(source = "imageName", target = "imageName")
    BookDto mapBookToBookDto(Book book);
}
