package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.AddPublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.exception.notfound.PublisherNotFoundException;
import com.afulvio.booklify.bookservice.mapper.PublisherMapper;
import com.afulvio.booklify.bookservice.model.LocalError;
import com.afulvio.booklify.bookservice.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    private final PublisherMapper publisherMapper;

    @Transactional
    public GetPublisherResponse getPublisherById(Long id) {
        log.info("Start searching publisher with ID: {}", id);
        GetPublisherResponse response = new GetPublisherResponse();
        publisherRepository.findById(id).ifPresentOrElse(
                entity -> response.setPublisher(publisherMapper.entityToDTO(entity)),
                () -> { throw new PublisherNotFoundException(LocalError.E014.getMessage()); }
        );
        return response;
    }

    @Transactional
    public GetPublishersResponse getAllPublishers() {
        log.info("Start searching all the publishers");
        List<PublisherDTO> publishers = new ArrayList<>();
        publisherRepository.findAll()
                .forEach(entity -> publishers.add(publisherMapper.entityToDTO(entity)));
        return new GetPublishersResponse(publishers);
    }

    @Transactional
    public AddPublisherResponse addPublisher(AddPublisherRequest request) {
        log.info("Start saving a publisher");
        AddPublisherResponse response = new AddPublisherResponse();
        response.setPublisher(publisherMapper.entityToDTO(
                publisherRepository.save(
                        publisherMapper.requestToEntity(request))));
        return response;
    }

    @Transactional
    public DeletePublisherResponse deletePublisherById(Long id) {
        log.info("Start deleting a publisher with ID: {}", id);
        DeletePublisherResponse response = new DeletePublisherResponse();
        publisherRepository.deleteById(id);
        return response;
    }

    @Transactional
    public UpdatePublisherResponse updatePublisher(UpdatePublisherRequest request) {
        log.info("Start updating a publisher");
        UpdatePublisherResponse response = new UpdatePublisherResponse();
        publisherRepository.findById(request.getId()).ifPresentOrElse(
                entity -> response.setPublisher(
                        publisherMapper.entityToDTO(
                                publisherRepository.save(
                                        publisherMapper.requestToEntity(request)))),
                () -> { throw new PublisherNotFoundException(LocalError.E015.getMessage()); }
        );
        return response;
    }
    
}
