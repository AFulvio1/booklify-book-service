package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.BaseIntegrationTest;
import com.afulvio.booklify.bookservice.dto.request.SavePublisherRequest;
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
    public void testGet_OK() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 8)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.publisher.name").value("Holtzbrinck Publishing Group"));
    }

    @Test
    @Order(2)
    public void testGet_KO() throws Exception {
        this.mockMvc.perform(get(BASE_URL + "/get/{id}", 9)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the publisher"));
    }

    @Test
    @Order(3)
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
    @Order(4)
    public void testSave_OK() throws Exception {
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
    public void testUpdate_OK() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdatePublisherRequest(9L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.publisher.name").value("Test Renamed"));
    }

    @Test
    @Order(6)
    public void testUpdate_KO() throws Exception {
        this.mockMvc.perform(put(BASE_URL + "/update")
                        .content(this.objectMapper.writeValueAsBytes(buildUpdatePublisherRequest(10L)))
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("it was not possible to recover the publisher for update"));
    }

    @Test
    @Order(7)
    public void testDelete_OK() throws Exception {
        this.mockMvc.perform(delete(BASE_URL + "/delete/{id}", 9)
                        .characterEncoding("utf-8")
                        .contentType(MediaTypes.HAL_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.publisher").isEmpty());
    }



    private SavePublisherRequest buildAddPublisherRequest() {
        return SavePublisherRequest.builder()
                .name("Test")
                .country("Test")
                .zip("00000")
                .build();
    }

    private UpdatePublisherRequest buildUpdatePublisherRequest(Long id) {
        return UpdatePublisherRequest.builder()
                .id(id)
                .name("Test Renamed")
                .build();
    }

}
