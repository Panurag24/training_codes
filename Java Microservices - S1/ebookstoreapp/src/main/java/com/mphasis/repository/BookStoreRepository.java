package com.mphasis.repository;

import com.mphasis.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookStoreRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findAllByBookId(Long bookId);

    void deleteByBookId(Long bookId);

    List<Book> findByBookTitle(String bookTitle);

    List<Book> findByBookPublisherLike(String bookPublisher);

    List<Book> findByYear(int year);
}
