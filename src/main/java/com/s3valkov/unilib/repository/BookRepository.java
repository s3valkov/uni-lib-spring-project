package com.s3valkov.unilib.repository;

import com.s3valkov.unilib.database.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByLanguage(String language);

    List<Book> findByAuthor(String Author);
}
