package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.AddCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import com.afulvio.booklify.bookservice.mapper.CategoryMapper;
import com.afulvio.booklify.bookservice.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Transactional
    public GetCategoryResponse getCategoryById(Long id) {
        log.info("Start searching category with ID: {}", id);
        GetCategoryResponse response = new GetCategoryResponse();
        try {
            categoryRepository.findById(id).ifPresentOrElse(
                    entity -> response.setCategory(categoryMapper.entityToDTO(entity)),
                    () -> log.warn("Category not founded")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Category founded");
        return response;
    }

    @Transactional
    public GetCategoriesResponse getAllCategories() {
        log.info("Start searching all the categories");
        List<CategoryDTO> categories = new ArrayList<>();
        try {
            categoryRepository.findAll()
                    .forEach(entity -> categories.add(categoryMapper.entityToDTO(entity)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Categories founded");
        return new GetCategoriesResponse(categories);
    }

    @Transactional
    public AddCategoryResponse addCategory(AddCategoryRequest request) {
        log.info("Start saving a category");
        AddCategoryResponse response = new AddCategoryResponse();
        try {
            response.setCategory(
                    categoryMapper.entityToDTO(
                            categoryRepository.save(
                                    categoryMapper.requestToEntity(request))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Category saved");
        return response;
    }

    @Transactional
    public DeleteCategoryResponse deleteCategoryById(Long id) {
        log.info("Start deleting a category with ID: {}", id);
        CategoryDTO deletedCategory;
        try {
            categoryRepository.deleteById(id);
            deletedCategory = categoryMapper.entityToDTO(categoryRepository.findById(id).orElse(new CategoryEntity()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Category deleted");
        return new DeleteCategoryResponse(deletedCategory);
    }

    @Transactional
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request) {
        log.info("Start updating a category");
        UpdateCategoryResponse response = new UpdateCategoryResponse();
        try {
            categoryRepository.findById(request.getId()).ifPresentOrElse(
                    category -> response.setCategory(categoryMapper.entityToDTO(
                            categoryRepository.save(categoryMapper.requestToEntity(request)))),
                    () -> log.info("Category not founded for update")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Category updated");
        return response;
    }

}
