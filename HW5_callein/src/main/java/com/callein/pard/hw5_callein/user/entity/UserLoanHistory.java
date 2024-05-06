package com.callein.pard.hw5_callein.user.entity;

import com.callein.pard.hw5_callein.book.entity.Book;
import com.callein.pard.hw5_callein.user.dto.UserLoanHistoryDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

    public static UserLoanHistory toEntity(UserLoanHistoryDTO.Create dto, User user, Book book){
        return UserLoanHistory.builder()
                .id(dto.getId())
                .user(user)
                .book(book)
                .isReturn(dto.isReturn())
                .build();
    }
    public void returnBook(){
        this.isReturn = true;
    }

}
