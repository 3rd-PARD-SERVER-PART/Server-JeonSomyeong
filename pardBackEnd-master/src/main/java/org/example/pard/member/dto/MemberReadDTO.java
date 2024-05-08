package org.example.pard.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pard.member.entity.Member;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberReadDTO {
    private Long id;
    private String name;
    private String part;
    private int age;

//    Member 엔티티를 받아와서 DTO 로 변환.
//    DTO 를 사용하면 entity 의 오염을 막고 의존성을 낮출 수 있다.
    public MemberReadDTO toDTO(Member member) {
        return MemberReadDTO.builder()
                .id(member.getId())
                .age(member.getAge())
                .name(member.getName())
                .part(member.getPart())
                .build();
    }
}