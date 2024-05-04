package com.callein.pard.hw4_callein.book.entity;

import com.callein.pard.hw4_callein.book.dto.BookCreateDTO;
import com.callein.pard.hw4_callein.book.dto.BookUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private  String name;

    @ColumnDefault("0")
    private boolean isLoan;

    public void update(BookUpdateDTO dto) {
        this.name = dto.getName();
        this.isLoan = dto.isLoan();
    }

    // 위와 아래는 같은거다. 그런데, 위 처럼 생성자로 쓰면 업데이트가 안된다.
    // 아래는 업데이트까지 해줄 수 있다.
    public static Book toEntity(BookCreateDTO dto){
        return Book.builder()
                .name(dto.getName())
                .build();
    }

    public void changeState(boolean state){
        this.isLoan = state;
    }
}
