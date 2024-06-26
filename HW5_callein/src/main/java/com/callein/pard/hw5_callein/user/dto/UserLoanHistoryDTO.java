package com.callein.pard.hw5_callein.user.dto;

import com.callein.pard.hw5_callein.book.dto.BookReadDTO;
import com.callein.pard.hw5_callein.user.entity.UserLoanHistory;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

public class UserLoanHistoryDTO {
    @Getter
    @Setter
    public static class Create {
        private Long id;
        private Long userId;
        private Long bookId;
        private boolean isReturn;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read {
        private Long id;
        private UserDTO.Read userDto;
        private BookReadDTO bookDto;
        private boolean isReturn;
        public Read(UserLoanHistory userLoanHistory, UserDTO.Read userDto, BookReadDTO bookDto){
            this.id = userLoanHistory.getId();
            this.isReturn = userLoanHistory.isReturn();
            this.bookDto = bookDto;
            this.userDto = userDto;
        }
    }
}
