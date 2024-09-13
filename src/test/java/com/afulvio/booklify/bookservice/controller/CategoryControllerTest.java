package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.request.AddCategoryRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateCategoryRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest extends BaseIntegrationTest {

    private final String BASE_URL = "/api/categories";

    @Test
    @Order(1)
    public void testGetCategory_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category.name").value("Fiction"));
    }

    @Test
    @Order(2)
    public void testGetAll_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get-all")
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories.size()").value(10))
                .andExpect(jsonPath("$.categories[0].id").value(1));
    }

    @Test
    @Order(3)
    public void testSaveCategory_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddCategoryRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.category.name").value("Test"));
    }

    @Test
    @Order(5)
    public void testDeleteCategory_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 11)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category.name").isEmpty());
    }

    @Test
    @Order(4)
    public void testUpdateCategory_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateCategoryRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.category.name").value("Test Renamed"));
    }

    private AddCategoryRequest buildAddCategoryRequest() {
        return AddCategoryRequest.builder()
                .name("Test")
                .build();
    }

    private UpdateCategoryRequest buildUpdateCategoryRequest() {
        return UpdateCategoryRequest.builder()
                .id(5L)
                .name("Test Renamed")
                .build();
    }

}
