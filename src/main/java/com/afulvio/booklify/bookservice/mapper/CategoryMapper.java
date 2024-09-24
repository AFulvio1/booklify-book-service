package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO entityToDTO(CategoryEntity categoryEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    @Mapping(target = "tms", ignore = true)
    CategoryEntity requestToEntity(SaveCategoryRequest request);

    @Mapping(target = "books", ignore = true)
    @Mapping(target = "tms", ignore = true)
    CategoryEntity requestToEntity(UpdateCategoryRequest request);

}
