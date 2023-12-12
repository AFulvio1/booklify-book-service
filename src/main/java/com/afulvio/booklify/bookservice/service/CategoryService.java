package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.CategoryDto;
import com.afulvio.booklify.bookservice.entity.Category;
import com.afulvio.booklify.bookservice.mapper.CategoryMapper;
import com.afulvio.booklify.bookservice.repository.CategoryRepository;
import com.afulvio.booklify.bookservice.util.CategoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDto getCategoryById(Integer id) {
        log.info("Start searching categories");
        Optional<Category> opt = categoryRepository.findById(id);
        if (opt.isPresent()) {
            log.info("Cateogry founded");
            return CategoryMapper.MAPPER.mapCategoryToCategoryDto(opt.get());
        }
        log.info("Cateogry not founded");
        return CategoryDto.builder().build();
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {
        log.info("Start saving a category");
        Category savedCategory = categoryRepository.save(CategoryMapper.MAPPER.mapCategoryDtoToCategory(categoryDto));
        log.info("Category saved");
        return CategoryMapper.MAPPER.mapCategoryToCategoryDto(savedCategory);
    }

    public Void deleteCategoryById(Integer id) {
        log.info("Start deleting a category");
        categoryRepository.deleteById(id);
        log.info("Category deleted");
        return null;
    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }



    public Optional<Category> updateCategoryById(int id) {
        return categoryRepository.findById(id);
    }



    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
