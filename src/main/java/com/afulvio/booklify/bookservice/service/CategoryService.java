package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
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
                category =  categoryMapper.mapCategoryToCategoryDto(opt.get());
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
                entities.forEach(entity -> categories.add(categoryMapper.mapCategoryToCategoryDto(entity)));
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
            CategoryEntity savedCategoryEntity = categoryRepository.save(categoryMapper.mapCategoryDtoToCategory(categoryDto));
            log.info("Category saved");
            savedCategory =  categoryMapper.mapCategoryToCategoryDto(savedCategoryEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new AddCategoryResponse(savedCategory);
    }

    @Transactional
    public DeleteCategoryResponse deleteCategoryById(Long id) {
        log.info("Start deleting a category with ID: {}", id);
        categoryRepository.deleteById(id);
        log.info("Category deleted");
        return new DeleteCategoryResponse();
    }

    @Transactional
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request) {
        try {
            log.info("Start updating a category");
            Optional<CategoryEntity> entity = categoryRepository.findById(request.getCategory().getId());
            if (entity.isPresent()) {
                log.info("Category founded for update");
                categoryRepository.save(entity.get());
            }
            else log.warn("Category not founded for update");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new UpdateCategoryResponse();
    }

}
