package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
import com.afulvio.booklify.bookservice.dto.request.AddPublisherRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdatePublisherRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.PublisherEntity;
import com.afulvio.booklify.bookservice.mapper.PublisherMapper;
import com.afulvio.booklify.bookservice.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        try {
            publisherRepository.findById(id).ifPresentOrElse(
                    entity -> response.setPublisher(publisherMapper.entityToDTO(entity)),
                    () -> log.warn("Publisher not founded")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Publisher founded");
        return response;
    }

    @Transactional
    public GetPublishersResponse getAllPublishers() {
        log.info("Start searching all the publishers");
        List<PublisherDTO> publishers = new ArrayList<>();
        try {
            publisherRepository.findAll()
                    .forEach(entity -> publishers.add(publisherMapper.entityToDTO(entity)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Publishers founded");
        return new GetPublishersResponse(publishers);
    }

    @Transactional
    public AddPublisherResponse addPublisher(AddPublisherRequest request) {
        log.info("Start saving a publisher");
        AddPublisherResponse response = new AddPublisherResponse();
        try {
            response.setPublisher(publisherMapper.entityToDTO(
                    publisherRepository.save(
                            publisherMapper.requestToEntity(request))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Publisher saved");
        return response;
    }

    @Transactional
    public DeletePublisherResponse deletePublisherById(Long id) {
        log.info("Start deleting a publisher with ID: {}", id);
        DeletePublisherResponse response = new DeletePublisherResponse();
        try {
            publisherRepository.deleteById(id);
            response.setPublisher(new PublisherDTO());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Publisher deleted");
        return response;
    }

    @Transactional
    public UpdatePublisherResponse updatePublisher(UpdatePublisherRequest request) {
        log.info("Start updating a publisher");
        UpdatePublisherResponse response = new UpdatePublisherResponse();
        try {
            publisherRepository.findById(request.getId()).ifPresentOrElse(
                    entity -> response.setPublisher(
                            publisherMapper.entityToDTO(
                                    publisherRepository.save(
                                            publisherMapper.requestToEntity(request)))),
                    () -> log.warn("Publisher not founded for update")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    
}
