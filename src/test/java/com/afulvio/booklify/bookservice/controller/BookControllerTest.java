package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.BookDTO;
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
    @Order(3)
    public void testSaveBook_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddBookRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.book.author").value("Test"));
    }

    @Test
    @Order(5)
    public void testDeleteBook_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 5)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testUpdateBook_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdateBookRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.book.author").value("Test"));
    }

    private AddBookRequest buildAddBookRequest() {
        return AddBookRequest.builder()
                .author("Test")
                .build();
    }

    private UpdateBookRequest buildUpdateBookRequest() {
        return UpdateBookRequest.builder()
                .id(1L)
                .author("Test")
                .build();
    }

}
