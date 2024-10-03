package com.afulvio.booklify.bookservice.controller;

import com.afulvio.booklify.bookservice.dto.request.SavePublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<GetPublisherResponse> get(
            @PathVariable("id") @Valid final Long id
    ){
        GetPublisherResponse response = publisherService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all the Publishers")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<GetPublishersResponse> get(){
        GetPublishersResponse response = publisherService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a Publisher")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    public ResponseEntity<SavePublisherResponse> save(
            @RequestBody final SavePublisherRequest request,
            UriComponentsBuilder uriBuilder
    ){
        SavePublisherResponse response = publisherService.save(request);
        URI location = uriBuilder.path("/api/books/{id}")
                .buildAndExpand(response.getPublisher().getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Publisher by ID")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DeletePublisherResponse> delete(
            @PathVariable("id") @Valid final Long id
    ){
        DeletePublisherResponse response = publisherService.deleteById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a Publisher")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 OK")
    public ResponseEntity<UpdatePublisherResponse> update(
            @PathVariable @Valid @NotNull final Long id,
            @RequestBody UpdatePublisherRequest request
    ){
        UpdatePublisherResponse response = publisherService.update(id, request);
        return ResponseEntity.accepted().body(response);
    }
    
}
