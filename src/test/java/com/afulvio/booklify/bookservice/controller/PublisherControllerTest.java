package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.AddPublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PublisherControllerTest extends BaseIntegrationTest {

    private final String BASE_URL = "/api/publishers";

    @Test
    @Order(1)
    public void testGetPublisher_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 1)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.publisher.name").value("Penguin Random House"));
    }

    @Test
    @Order(2)
    public void testGetAll_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get-all")
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.publishers.size()").value(8))
                .andExpect(jsonPath("$.publishers[0].id").value(1));
    }

    @Test
    @Order(3)
    public void testSavePublisher_OK() throws Exception {
        this.mockMvc.perform(post(BASE_URL + "/add")
                        .content(this.objectMapper.writeValueAsBytes(buildAddPublisherRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.publisher.name").value("Test"));
    }

    @Test
    @Order(5)
    public void testDeletePublisher_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 11)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.publisher.name").isEmpty());
    }

    @Test
    @Order(4)
    public void testUpdatePublisher_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdatePublisherRequest()))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.publisher.name").value("Test Renamed"));
    }

    private AddPublisherRequest buildAddPublisherRequest() {
        return AddPublisherRequest.builder()
                .name("Test")
                .country("Test")
                .zip("00000")
                .build();
    }

    private UpdatePublisherRequest buildUpdatePublisherRequest() {
        return UpdatePublisherRequest.builder()
                .id(5L)
                .name("Test Renamed")
                .build();
    }

}
