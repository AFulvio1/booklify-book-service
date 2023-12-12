package com.afulvio.booklify.bookservice.service;

import com.afulvio.booklify.bookservice.dto.BookDto;
import com.afulvio.booklify.bookservice.entity.Book;
import com.afulvio.booklify.bookservice.mapper.BookMapper;
import com.afulvio.booklify.bookservice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    public BookDto getBookById(Long id) {
        log.info("Start searching a book");
        Optional<Book> opt = bookRepository.findById(id);
        if (opt.isPresent()) {
            log.info("Book founded");
            return BookMapper.MAPPER.mapBookToBookDto(opt.get());
        }
        log.info("Book not founded");
        return BookDto.builder().build();
    }

    public List<BookDto> getAllBooks() {
        log.info("Start searching all book");
        List<Book> bookList = bookRepository.findAll();
        return CollectionUtils.isNotEmpty(bookList)
                ? bookList.stream().map(BookMapper.MAPPER::mapBookToBookDto).collect(Collectors.toList())
                : new ArrayList<>();
    }

    public BookDto addBook(BookDto bookDto) {
        log.info("Start adding a book");
        Book savedBook = bookRepository.save(BookMapper.MAPPER.mapBookDtoToBook(bookDto));
        log.info("Book added");
        return BookMapper.MAPPER.mapBookToBookDto(savedBook);
    }

    public Void deleteBookById(Long id) {
        log.info("Start deleting a book");
        bookRepository.deleteById(id);
        log.info("Book deleted");
        return null;
    }

    public List<Book> getAllBooksByCategory(int id) {
        return bookRepository.findAllByCategory_id(id);
    }

    public List<Book> getAllBooksByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public List<Book> getAllBooksByAuthor(String keyword) {
        return bookRepository.findByAuthorContaining(keyword);
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
