package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.AddCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity dtoToEntity(CategoryDTO categoryDto);

    CategoryDTO entityToDTO(CategoryEntity categoryEntity);

    CategoryEntity requestToEntity(AddCategoryRequest request);

    CategoryEntity requestToEntity(UpdateCategoryRequest request);

}
