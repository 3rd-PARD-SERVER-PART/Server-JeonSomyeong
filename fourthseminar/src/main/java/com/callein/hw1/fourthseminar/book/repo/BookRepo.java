package com.callein.hw1.fourthseminar.book.repo;

import com.callein.hw1.fourthseminar.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
