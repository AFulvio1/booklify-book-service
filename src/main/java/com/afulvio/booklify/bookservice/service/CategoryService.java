package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import com.afulvio.booklify.bookservice.mapper.CategoryMapper;
import com.afulvio.booklify.bookservice.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Transactional
    public GetCategoryResponse getCategoryById(Long id) {
        CategoryDTO category = null;
        try {
            log.info("Start searching category with ID: {}", id);
            Optional<CategoryEntity> opt = categoryRepository.findById(id);
            if (opt.isPresent()) {
                log.info("Category founded");
                category =  categoryMapper.entityToDTO(opt.get());
            }
            else log.warn("Category not founded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetCategoryResponse(category);
    }

    @Transactional
    public GetCategoriesResponse getAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();
        try {
            log.info("Start searching all the categories");
            List<CategoryEntity> entities = categoryRepository.findAll();
            if (CollectionUtils.isNotEmpty(entities)) {
                log.info("Categories founded");
                entities.forEach(entity -> categories.add(categoryMapper.entityToDTO(entity)));
            }
            else log.warn("Categories not founded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetCategoriesResponse(categories);
    }

    @Transactional
    public AddCategoryResponse addCategory(CategoryDTO categoryDto) {
        CategoryDTO savedCategory;
        try {
            log.info("Start saving a category");
            CategoryEntity savedCategoryEntity = categoryRepository.save(categoryMapper.dtoToEntity(categoryDto));
            log.info("Category saved");
            savedCategory =  categoryMapper.entityToDTO(savedCategoryEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new AddCategoryResponse(savedCategory);
    }

    @Transactional
    public DeleteCategoryResponse deleteCategoryById(Long id) {
        DeleteCategoryResponse response;
        try {
            log.info("Start deleting a category with ID: {}", id);
            categoryRepository.deleteById(id);
            response = new DeleteCategoryResponse(
                    categoryMapper.entityToDTO(categoryRepository.findById(id).orElse(new CategoryEntity()))
            );
            log.info("Category deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Transactional
    public UpdateCategoryResponse updateCategory(CategoryDTO category) {
        UpdateCategoryResponse response = null;
        try {
            log.info("Start updating a category");
            Optional<CategoryEntity> entity = categoryRepository.findById(category.getId());
            if (entity.isPresent()) {
                log.info("Category founded for update");
                CategoryEntity updatedEntity = categoryRepository.save(categoryMapper.dtoToEntity(category));
                response = new UpdateCategoryResponse(categoryMapper.entityToDTO(updatedEntity));
            }
            else log.warn("Category not founded for update");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}
