package com.callein.pard.hw5_callein.book.dto;

import com.callein.pard.hw5_callein.book.entity.Book;
import com.callein.pard.hw5_callein.user.dto.UserDTO;
import com.callein.pard.hw5_callein.user.dto.UserLoanHistoryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReadDTO {
    private Long bookId;
    private String name;
    private boolean isLoan;
    private UserDTO.Read user;
    private UserLoanHistoryDTO.Read history;

    public BookReadDTO(Book book) {
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.isLoan = book.isLoan();
    }
    public BookReadDTO(Book book, UserDTO.Read user){
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.user = user;
    }
    public BookReadDTO(Book book, UserLoanHistoryDTO.Read history){
        this.bookId = book.getBookId();
        this.history = history;
    }

}
