package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.BookDTO;
import com.afulvio.booklify.bookservice.dto.request.AddBookRequest;
import com.afulvio.booklify.bookservice.dto.response.AddBookResponse;
import com.afulvio.booklify.bookservice.dto.response.DeleteBookResponse;
import com.afulvio.booklify.bookservice.dto.response.GetBookResponse;
import com.afulvio.booklify.bookservice.dto.response.GetBooksResponse;
import com.afulvio.booklify.bookservice.entity.BookEntity;
import com.afulvio.booklify.bookservice.mapper.BookMapper;
import com.afulvio.booklify.bookservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Transactional
    public GetBookResponse getBookById(Long id) {
        log.info("Start searching a book with ID: {}", id);
        BookDTO book = BookDTO.builder().build();
        try {
            Optional<BookEntity> opt = bookRepository.findById(id);
            if (opt.isPresent()) {
                log.info("Book founded");
                book = bookMapper.mapBookToBookDto(opt.get());
            }
            else log.info("Book not founded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetBookResponse(book);
    }

    @Transactional
    public GetBooksResponse getAllBooks() {
        log.info("Start searching all book");
        List<BookDTO> books = new ArrayList<>();
        try {
            List<BookEntity> entities = bookRepository.findAll();
            if (CollectionUtils.isNotEmpty(entities))
                books = entities.stream().map(bookMapper::mapBookToBookDto).collect(Collectors.toList());
            else
                log.warn("No books found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new GetBooksResponse(books);
    }

    @Transactional
    public AddBookResponse addBook(AddBookRequest request) {
        BookDTO savedBook;
        try {
            log.info("Start adding a book");
            BookEntity savedBookEntity = bookRepository.save(bookMapper.mapBookDtoToBook(request.getBookDTO()));
            savedBook = bookMapper.mapBookToBookDto(savedBookEntity);
            log.info("Book added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new AddBookResponse(savedBook);
    }

    @Transactional
    public DeleteBookResponse deleteBookById(Long id) {
        try {
            log.info("Start deleting a book with ID: {}", id);
            bookRepository.deleteById(id);
            log.info("Book deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new DeleteBookResponse();
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
