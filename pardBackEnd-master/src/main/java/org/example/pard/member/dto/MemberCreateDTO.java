package org.example.pard.member.dto;

import lombok.Getter;

@Getter
public class MemberCreateDTO {
//    Member 생성 시 필수정보만 포함. id 값은 자동 생성.
    private String name;
    private String part;
    private int age;

}
