package com.callein.pard.hw4_callein.user.servise;

import com.callein.pard.hw4_callein.book.dto.BookReadDTO;
import com.callein.pard.hw4_callein.book.entity.Book;
import com.callein.pard.hw4_callein.book.repo.BookRepo;
import com.callein.pard.hw4_callein.book.service.BookService;
import com.callein.pard.hw4_callein.user.dto.UserDTO;
import com.callein.pard.hw4_callein.user.dto.UserLoanHistoryDTO;
import com.callein.pard.hw4_callein.user.entity.UserLoanHistory;
import com.callein.pard.hw4_callein.user.repo.UserLoanHistoryRepo;
import com.callein.pard.hw4_callein.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLoanService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistoryRepo;
    private final BookService bookService;
    private final UserService userService;

    public void createLoanHistory(UserLoanHistoryDTO.Create dto){
        userLoanHistoryRepo.save(UserLoanHistory.toEntity(dto,
                userRepo.findById(dto.getUserId()).orElseThrow(),
                bookRepo.findById(dto.getBookId()).orElseThrow()
                ));
    }

    public boolean isBookReturned(UserLoanHistoryDTO.Create dto){
        return !bookRepo.findById(dto.getBookId()).get().isLoan();
    }

    public String requestLoan(UserLoanHistoryDTO.Create historyDTO){
        if (isBookReturned(historyDTO)){
            createLoanHistory(historyDTO);
            changeBookState(historyDTO.getBookId(),true);
            return "대여 성공";
        }
        return "대여 실패";
    }

    public String requestReturn(UserLoanHistoryDTO.Create historyDTO){
        if (isBookReturned(historyDTO)) return "반납 완료 도서";
        else{
            UserLoanHistory userLoanHistory = userLoanHistoryRepo.findById(historyDTO.getBookId()).orElseThrow();
            userLoanHistory.returnBook();
            userLoanHistoryRepo.save(userLoanHistory);
            changeBookState(historyDTO.getBookId(), false);
            return "반납 성공";
        }
    }

    public void changeBookState(Long bookId, boolean loan){
        Book book = bookRepo.findById(bookId).orElseThrow();
        book.changeState(loan);
        bookRepo.save(book);
    }

    public List<UserLoanHistoryDTO.Read> findAll(){
        return userLoanHistoryRepo.findAll()
                .stream()
                .map(history -> new UserLoanHistoryDTO.Read(history,
                        new UserDTO.Read(history.getUser()),
                        new BookReadDTO(history.getBook())
                        ))
                .collect(Collectors.toList());
    }
}
