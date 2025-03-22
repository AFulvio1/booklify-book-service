package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.SavePublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.PublisherEntity;
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
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    private final PublisherMapper publisherMapper;

    @Transactional
    public GetPublisherResponse getById(Long id) {
        log.info("Start searching publisher with ID: {}", id);
        GetPublisherResponse response = new GetPublisherResponse();
        publisherRepository.findById(id).ifPresentOrElse(
                entity -> response.setPublisher(publisherMapper.entityToDTO(entity)),
                () -> { throw new PublisherNotFoundException(LocalError.E014.getMessage()); }
        );
        return response;
    }

    @Transactional
    public GetPublishersResponse getAll() {
        log.info("Start searching all the publishers");
        List<PublisherDTO> publishers = publisherRepository.findAll()
                .stream().map(publisherMapper::entityToDTO)
                .toList();
        return new GetPublishersResponse(publishers);
    }

    @Transactional
    public SavePublisherResponse save(SavePublisherRequest request) {
        log.info("Start saving a publisher");
        SavePublisherResponse response = new SavePublisherResponse();
        publisherRepository.findByName(request.getName()).ifPresentOrElse(
                entity -> {
                    throw new PublisherNotFoundException(LocalError.E014.getMessage());
                },
                () -> {
                    PublisherEntity savedPublisher = publisherRepository.save(publisherMapper.requestToEntity(request));
                    response.setPublisher(publisherMapper.entityToDTO(savedPublisher));
                }
        );
        return response;
    }

    @Transactional
    public DeletePublisherResponse deleteById(Long id) {
        log.info("Start deleting a publisher with ID: {}", id);
        DeletePublisherResponse response = new DeletePublisherResponse();
        publisherRepository.deleteById(id);
        return response;
    }

    @Transactional
    public UpdatePublisherResponse update(Long id, UpdatePublisherRequest request) {
        log.info("Start updating a publisher with ID: {}", id);
        UpdatePublisherResponse response = new UpdatePublisherResponse();
        publisherRepository.findById(id).ifPresentOrElse(
                entity -> {
                    publisherMapper.updateFromRequest(request, entity);
                    response.setPublisher(publisherMapper.entityToDTO(publisherRepository.save(entity)));
                },
                () -> { throw new PublisherNotFoundException(LocalError.E015.getMessage()); }
        );
        return response;
    }
    
}
