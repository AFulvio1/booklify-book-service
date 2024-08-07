package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity mapCategoryDtoToCategory(CategoryDTO categoryDto);

    CategoryDTO mapCategoryToCategoryDto(CategoryEntity categoryEntity);

}
