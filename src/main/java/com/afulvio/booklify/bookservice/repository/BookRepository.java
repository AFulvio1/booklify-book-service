package com.afulvio.booklify.bookservice.repository;

import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByIsbn(String isbn);

    @Query(value = "SELECT b FROM BookEntity b WHERE b.category = :idCategory")
    List<BookEntity> findByCategory(Long idCategory);


    List<BookEntity> findByTitleContaining(String keyword);

    List<BookEntity> findByAuthorContaining(String keyword);
}