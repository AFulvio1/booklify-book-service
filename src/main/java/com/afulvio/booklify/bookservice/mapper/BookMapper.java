package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

//    @Mapping(source = "category", target = "category")
//    @Mapping(source = "author", target = "author")
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "subtitle", target = "subtitle")
//    @Mapping(source = "volume", target = "volume")
//    @Mapping(source = "year", target = "year")
//    @Mapping(source = "publisher", target = "publisher")
//    @Mapping(source = "isbn", target = "isbn")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "note", target = "note")
//    @Mapping(source = "image", target = "image")
    BookEntity mapBookDtoToBook(BookDTO bookDto);

//    @Mapping(source = "category", target = "category")
//    @Mapping(source = "author", target = "author")
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "subtitle", target = "subtitle")
//    @Mapping(source = "volume", target = "volume")
//    @Mapping(source = "yearOfPublication", target = "yearOfPublication")
//    @Mapping(source = "publishingHouse", target = "publishingHouse")
//    @Mapping(source = "placeOfPublication", target = "placeOfPublication")
//    @Mapping(source = "isbn", target = "isbn")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "note", target = "note")
//    @Mapping(source = "imageName", target = "imageName")
    BookDTO mapBookToBookDto(BookEntity bookEntity);
}
