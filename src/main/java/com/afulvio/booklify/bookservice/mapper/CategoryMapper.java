package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.CategoryDto;
import com.afulvio.booklify.bookservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "name", target = "name")
    Category mapCategoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(source = "name", target = "name")
    CategoryDto mapCategoryToCategoryDto(Category category);

}
