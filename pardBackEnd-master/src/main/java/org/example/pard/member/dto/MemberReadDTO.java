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

    public MemberReadDTO toDTO(Member member) {
        return MemberReadDTO.builder()
                .id(member.getId())
                .age(member.getAge())
                .name(member.getName())
                .part(member.getPart())
                .build();
    }
}


