package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.PublisherDTO;
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
        PublisherDTO publisher = null;
        try {
            log.info("Start searching publisher with ID: {}", id);
            Optional<PublisherEntity> opt = publisherRepository.findById(id);
            if (opt.isPresent()) {
                log.info("Publisher founded");
                publisher =  publisherMapper.entityToDTO(opt.get());
            }
            else log.warn("Publisher not founded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetPublisherResponse(publisher);
    }

    @Transactional
    public GetPublishersResponse getAllPublishers() {
        List<PublisherDTO> publishers = new ArrayList<>();
        try {
            log.info("Start searching all the publishers");
            List<PublisherEntity> entities = publisherRepository.findAll();
            if (CollectionUtils.isNotEmpty(entities)) {
                log.info("Publishers founded");
                entities.forEach(entity -> publishers.add(publisherMapper.entityToDTO(entity)));
            }
            else log.warn("Publishers not founded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetPublishersResponse(publishers);
    }

    @Transactional
    public AddPublisherResponse addPublisher(PublisherDTO PublisherDTO) {
        PublisherDTO savedPublisher;
        try {
            log.info("Start saving a publisher");
            PublisherEntity savedPublisherEntity = publisherRepository.save(publisherMapper.dtoToEntity(PublisherDTO));
            log.info("Publisher saved");
            savedPublisher =  publisherMapper.entityToDTO(savedPublisherEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new AddPublisherResponse(savedPublisher);
    }

    @Transactional
    public DeletePublisherResponse deletePublisherById(Long id) {
        DeletePublisherResponse response;
        try {
            log.info("Start deleting a publisher with ID: {}", id);
            publisherRepository.deleteById(id);
            response = new DeletePublisherResponse(new PublisherDTO());
            log.info("Publisher deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Transactional
    public UpdatePublisherResponse updatePublisher(PublisherDTO publisher) {
        UpdatePublisherResponse response = null;
        try {
            log.info("Start updating a publisher");
            Optional<PublisherEntity> entity = publisherRepository.findById(publisher.getId());
            if (entity.isPresent()) {
                log.info("Publisher founded for update");
                PublisherEntity updatedEntity = publisherRepository.save(publisherMapper.dtoToEntity(publisher));
                response = new UpdatePublisherResponse(publisherMapper.entityToDTO(updatedEntity));
            }
            else log.warn("Publisher not founded for update");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    
}
