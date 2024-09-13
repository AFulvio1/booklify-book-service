package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.request.UpdateBookRequest;
import com.afulvio.booklify.bookservice.dto.response.*;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import com.afulvio.booklify.bookservice.mapper.BookMapper;
import com.afulvio.booklify.bookservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Transactional
    public GetBookResponse getBookById(Long id) {
        log.info("Start searching a book with ID: {}", id);
        GetBookResponse response = new GetBookResponse();
        try {
            bookRepository.findById(id).ifPresentOrElse(
                    entity -> response.setBook(bookMapper.entityToDTO(entity)),
                    () -> log.info("Book not founded")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Book founded");
        return response;
    }

    @Transactional
    public GetBooksResponse getAllBooks() {
        log.info("Start searching all book");
        List<BookDTO> books = new ArrayList<>();
        try {
            bookRepository.findAll()
                    .forEach(entity -> books.add(bookMapper.entityToDTO(entity)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetBooksResponse(books);
    }

    @Transactional
    public AddBookResponse addBook(AddBookRequest request) {
        log.info("Start adding a book");
        AddBookResponse response = new AddBookResponse();
        try {
            response.setBook(bookMapper.entityToDTO(
                    bookRepository.save(
                            bookMapper.requestToEntity(request))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Book added");
        return response;
    }

    @Transactional
    public DeleteBookResponse deleteBookById(Long id) {
        log.info("Start deleting a book with ID: {}", id);
        BookDTO deletedBook;
        try {
            bookRepository.deleteById(id);
            deletedBook = bookMapper.entityToDTO(bookRepository.findById(id).orElse(new BookEntity()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Book deleted");
        return new DeleteBookResponse(deletedBook);
    }

    @Transactional
    public UpdateBookResponse updateBook(UpdateBookRequest request) {
        log.info("Start updating a book");
        UpdateBookResponse response = new UpdateBookResponse();
        try {
            bookRepository.findById(request.getId()).ifPresentOrElse(
                entity -> response.setBook(bookMapper.entityToDTO(bookRepository.save(bookMapper.requestToEntity(request)))),
                () -> log.info("No books founded for update")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Book updated");
        return response;
    }

    @Transactional
    public List<BookEntity> getAllBooksByCategory(Long id) {
        return bookRepository.findAllByCategory(id);
    }

    @Transactional
    public List<BookEntity> getAllBooksByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    @Transactional
    public List<BookEntity> getAllBooksByAuthor(String keyword) {
        return bookRepository.findByAuthorContaining(keyword);
    }

}
