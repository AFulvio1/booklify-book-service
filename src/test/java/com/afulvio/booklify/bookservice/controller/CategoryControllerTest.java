package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.request.SaveCategoryRequest;
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
    public void testGet_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category.name").value("Fiction"));
    }

    @Test
    @Order(2)
    public void testGet_KO2() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 20)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the category"));
    }

    @Test
    @Order(3)
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
    @Order(4)
    public void testSave_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddCategoryRequest("Test")))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.category.name").value("Test"));
    }

    @Test
    @Order(8)
    public void testSave_KO() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddCategoryRequest("")))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("There was an error validating your request"));
    }

    @Test
    @Order(5)
    public void testUpdate_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateCategoryRequest(11L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.category.name").value("Test Renamed"));
    }

    @Test
    @Order(6)
    public void testUpdate_KO() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateCategoryRequest(12L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the category for update"));
    }

    @Test
    @Order(7)
    public void testDelete_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 11)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category").isEmpty());
    }



    private SaveCategoryRequest buildAddCategoryRequest(String name) {
        return SaveCategoryRequest.builder()
                .name(name)
                .build();
    }

    private UpdateCategoryRequest buildUpdateCategoryRequest(Long id) {
        return UpdateCategoryRequest.builder()
                .id(id)
                .name("Test Renamed")
                .build();
    }

}
