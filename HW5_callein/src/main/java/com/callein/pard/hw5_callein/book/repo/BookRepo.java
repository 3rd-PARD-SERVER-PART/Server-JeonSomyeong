package com.callein.pard.hw5_callein.book.repo;

import com.callein.pard.hw4_callein.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
