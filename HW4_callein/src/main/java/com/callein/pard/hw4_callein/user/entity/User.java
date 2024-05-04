package com.callein.pard.hw4_callein.user.entity;

import com.callein.pard.hw4_callein.user.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private Integer age;
    private String major;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public static User toEntity(UserDTO.Create dto) {
        return User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .major(dto.getMajor())
                .build();
    }
}
