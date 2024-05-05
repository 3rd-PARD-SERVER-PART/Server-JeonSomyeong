package com.callein.pard.hw5_callein.book.controller;

import com.callein.pard.hw5_callein.book.dto.BookCreateDTO;
import com.callein.pard.hw5_callein.book.dto.BookReadDTO;
import com.callein.pard.hw5_callein.book.dto.BookUpdateDTO;
import com.callein.pard.hw5_callein.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String createBook(@RequestBody BookCreateDTO dto) {
        bookService.createBook(dto);
        return "추가됨";
    }

    @GetMapping("")
    public List<BookReadDTO> findAll() {
        return bookService.findById();
    }

    @GetMapping("/{id}")
    public BookReadDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PatchMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookUpdateDTO dto) {
        bookService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    public List<BookReadDTO> deleteById(@PathVariable Long id) {
        return bookService.deleteById(id);
    }
}