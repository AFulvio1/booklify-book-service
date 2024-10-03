package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.SaveBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import com.afulvio.booklify.bookservice.exception.notfound.BookNotFoundException;
import com.afulvio.booklify.bookservice.mapper.BookMapper;
import com.afulvio.booklify.bookservice.model.LocalError;
import com.afulvio.booklify.bookservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Transactional
    public GetBookResponse getById(Long id) {
        log.info("Start searching a book with ID: {}", id);
        GetBookResponse response = new GetBookResponse();
        bookRepository.findById(id).ifPresentOrElse(
                entity -> response.setBook(bookMapper.entityToDTO(entity)),
                () -> { throw new BookNotFoundException(LocalError.E010.getMessage()); }
        );
        return response;
    }

    @Transactional
    public GetBooksResponse getAll() {
        log.info("Start searching all book");
        List<BookDTO> books = bookRepository.findAll().stream()
                .map(bookMapper::entityToDTO)
                .toList();
        return new GetBooksResponse(books);
    }

    @Transactional
    public SaveBookResponse save(SaveBookRequest request) {
        log.info("Start saving a book");
        SaveBookResponse response = new SaveBookResponse();
        bookRepository.findByIsbn(request.getIsbn()).ifPresentOrElse(
                book -> {
                    throw new BookNotFoundException(LocalError.E010.getMessage());
                },
                () -> {
                    BookEntity savedBook = bookRepository.save(bookMapper.requestToEntity(request));
                    response.setBook(bookMapper.entityToDTO(savedBook));
                }
        );
        return response;
    }

    @Transactional
    public DeleteBookResponse deleteById(Long id) {
        log.info("Start deleting a book with ID: {}", id);
        bookRepository.deleteById(id);
        return new DeleteBookResponse();
    }

    @Transactional
    public UpdateBookResponse update(UpdateBookRequest request) {
        log.info("Start updating a book with ID: {}", request.getId());
        UpdateBookResponse response = new UpdateBookResponse();
        bookRepository.findById(request.getId()).ifPresentOrElse(
            entity -> {
                bookMapper.updateFromRequest(request,entity);
                response.setBook(bookMapper.entityToDTO(bookRepository.save(entity)));
            },
            () -> { throw new BookNotFoundException(LocalError.E011.getMessage()); }
        );
        return response;
    }

    @Transactional
    public List<BookEntity> getAllByCategory(Long id) {
        return bookRepository.findAllByCategory(id);
    }

    @Transactional
    public List<BookEntity> getAllByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    @Transactional
    public List<BookEntity> getAllByAuthor(String keyword) {
        return bookRepository.findByAuthorContaining(keyword);
    }

}
