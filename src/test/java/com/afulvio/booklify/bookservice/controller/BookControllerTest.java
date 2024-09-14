package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.CategoryDTO;
import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest extends BaseIntegrationTest {

    private final String BASE_URL = "/api/books";

    @Test
    @Order(1)
    public void testGetBook_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.book.author").value("J.K. Rowling"));
    }

    @Test
    @Order(2)
    public void testGetBook_KO() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 6)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the book"));
    }

    @Test
    @Order(3)
    public void testGetAll_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get-all")
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.books.size()").value(5))
                .andExpect(jsonPath("$.books[0].id").value(1));
    }

    @Test
    @Order(4)
    public void testSaveBook_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddBookRequest("Test")))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.book.author").value("Test"));
    }

    @Test
    @Order(8)
    public void testSaveBook_KO() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddBookRequest("")))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(5)
    public void testUpdateBook_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateBookRequest(6L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.book.author").value("Test Renamed"));
    }

    @Test
    @Order(6)
    public void testUpdateBook_KO() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateBookRequest(7L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the book for update"));
    }

    @Test
    @Order(7)
    public void testDeleteBook_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 5)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private AddBookRequest buildAddBookRequest(String author) {
        return AddBookRequest.builder()
                .author(author)
                .category(CategoryDTO.builder().id(1L).build())
                .title("Test")
                .publisher(PublisherDTO.builder().id(1L).build())
                .build();
    }

    private UpdateBookRequest buildUpdateBookRequest(Long id) {
        return UpdateBookRequest.builder()
                .id(id)
                .author("Test Renamed")
                .build();
    }

}
