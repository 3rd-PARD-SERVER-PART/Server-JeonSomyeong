package com.callein.pard.hw5_callein.user.dto;

import com.callein.pard.hw5_callein.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserDTO {
    @Getter
    @Setter
    public static class Create{
        private String name;
        private String email;
    }
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private String email;
        private List<UserLoanHistoryDTO.Read> userLoanHistories;

        // history 가 없는 유저 탐색
        public Read(User user, List<UserLoanHistoryDTO.Read> history){
            this.id = user.getUserId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.userLoanHistories = history;
        }
        // history 가 있는 유저 탐색
        public Read(User user) {
            this.id = user.getUserId();
            this.name = user.getName();
            this.email = user.getEmail();
        }
    }
}
