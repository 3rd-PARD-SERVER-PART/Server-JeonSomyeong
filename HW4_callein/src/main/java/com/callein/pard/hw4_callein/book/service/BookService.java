package com.callein.pard.hw4_callein.book.service;

import com.callein.pard.hw4_callein.book.dto.BookCreateDTO;
import com.callein.pard.hw4_callein.book.dto.BookReadDTO;
import com.callein.pard.hw4_callein.book.dto.BookUpdateDTO;
import com.callein.pard.hw4_callein.book.entity.Book;
import com.callein.pard.hw4_callein.book.repo.BookRepo;
import com.callein.pard.hw4_callein.user.dto.UserDTO;
import com.callein.pard.hw4_callein.user.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public void createBook(BookCreateDTO dto) {
        bookRepo.save(Book.toEntity(dto));
    }

    public List<BookReadDTO> findAll() {
        return bookRepo.findAll()
                .stream()
                .map(BookReadDTO::new)
                .collect(Collectors.toList());
    }

    public BookReadDTO findById(Long id) {
        return new BookReadDTO(bookRepo.findById(id).orElseThrow());
    }
    public List<BookReadDTO> findById() {
        return bookRepo.findAll()
                .stream()
                .map(BookReadDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateById(Long id, BookUpdateDTO dto) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.update(dto);
        bookRepo.save(book);
    }

    public List<BookReadDTO> deleteById(Long id) {
        bookRepo.deleteById(id);
        return findAll();
    }




}
