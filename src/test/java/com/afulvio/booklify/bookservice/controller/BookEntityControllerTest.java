package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookEntityControllerTest extends BaseIntegrationTest {

    private final String BASE_URL = "/api/books";

    @Test
    public void testGetBook_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get-book/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllBooks_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get-all-books")
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveBook_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add-book")
                        .content(this.objectMapper.writeValueAsBytes(BookDTO.builder().build()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete-book/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
