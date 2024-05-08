package org.example.pard.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String part;

    private int age;

    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
