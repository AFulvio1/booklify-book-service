package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.CategoryEntity;
import com.afulvio.booklify.bookservice.exception.notfound.CategoryNotFoundException;
import com.afulvio.booklify.bookservice.mapper.CategoryMapper;
import com.afulvio.booklify.bookservice.model.LocalError;
import com.afulvio.booklify.bookservice.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Transactional
    public GetCategoryResponse getById(Long id) {
        log.info("Start searching category with ID: {}", id);
        GetCategoryResponse response = new GetCategoryResponse();
        categoryRepository.findById(id).ifPresentOrElse(
                entity -> response.setCategory(categoryMapper.entityToDTO(entity)),
                () -> { throw new CategoryNotFoundException(LocalError.E012.getMessage()); }
        );
        return response;
    }

    @Transactional
    public GetCategoriesResponse getAll() {
        log.info("Start searching all the categories");
        List<CategoryDTO> categories = categoryRepository.findAll().stream()
                .map(categoryMapper::entityToDTO)
                .toList();
        return new GetCategoriesResponse(categories);
    }

    @Transactional
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        log.info("Start saving a category");
        SaveCategoryResponse response = new SaveCategoryResponse();
        categoryRepository.findByName(request.getName()).ifPresentOrElse(
                entity -> {
                    throw new CategoryNotFoundException(LocalError.E012.getMessage());
                },
                () -> {
                    CategoryEntity savedCategory = categoryRepository.save(categoryMapper.requestToEntity(request));
                    response.setCategory(categoryMapper.entityToDTO(savedCategory));
                }
        );
        return response;
    }

    @Transactional
    public DeleteCategoryResponse deleteById(Long id) {
        log.info("Start deleting a category with ID: {}", id);
        categoryRepository.deleteById(id);
        return new DeleteCategoryResponse();
    }

    @Transactional
    public UpdateCategoryResponse update(Long id, UpdateCategoryRequest request) {
        log.info("Start updating a category with ID: {}", id);
        UpdateCategoryResponse response = new UpdateCategoryResponse();
        categoryRepository.findById(id).ifPresentOrElse(
                entity -> {
                    categoryMapper.updateFromRequest(request, entity);
                    response.setCategory(categoryMapper.entityToDTO(categoryRepository.save(entity)));
                },
                () -> { throw new CategoryNotFoundException(LocalError.E013.getMessage()); }
        );
        log.info("Category updated");
        return response;
    }

}
