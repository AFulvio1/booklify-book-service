package com.afulvio.booklify.bookservice.mapper;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    CategoryDTO entityToDTO(CategoryEntity categoryEntity);
    
    CategoryEntity requestToEntity(SaveCategoryRequest request);

    void updateFromRequest(UpdateCategoryRequest request, @MappingTarget CategoryEntity entity);

}
