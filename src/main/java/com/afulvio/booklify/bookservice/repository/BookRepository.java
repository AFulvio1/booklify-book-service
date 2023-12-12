package com.afulvio.booklify.bookservice.repository;

import com.afulvio.booklify.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory_id(int id);

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByAuthorContaining(String keyword);
}