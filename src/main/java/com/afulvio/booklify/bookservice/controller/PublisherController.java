package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.AddPublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
@Tag(
        name = "Publishers APIs",
        description = "Create Publisher, Update Publisher, Get Publisher, Delete Publisher"
)
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping("/get/{id}")
    @Operation(summary = "Get Publisher by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetPublisherResponse> getPublisher(
            @PathVariable("id") @Valid final Long id
    ){
        GetPublisherResponse response = publisherService.getPublisherById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all the Publishers")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetPublishersResponse> getPublishers(){
        GetPublishersResponse response = publisherService.getAllPublishers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a Publisher")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<AddPublisherResponse> savePublisher(
            @RequestBody final AddPublisherRequest request
    ){
        AddPublisherResponse response = publisherService.addPublisher(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Publisher by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeletePublisherResponse> deletePublisher(
            @PathVariable("id") @Valid final Long id
    ){
        DeletePublisherResponse response = publisherService.deletePublisherById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a Book")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdatePublisherResponse> updatePublisher(
            @RequestBody UpdatePublisherRequest request
    ){
        UpdatePublisherResponse response = publisherService.updatePublisher(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    
}