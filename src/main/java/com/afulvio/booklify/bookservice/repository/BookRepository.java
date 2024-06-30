package com.afulvio.booklify.bookservice.repository;

import com.afulvio.booklify.bookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query(value = "SELECT b FROM BookEntity b WHERE b.category = :idCategory")
    List<BookEntity> findAllByCategory(Long idCategory);

    List<BookEntity> findByTitleContaining(String keyword);

    List<BookEntity> findByAuthorContaining(String keyword);
}