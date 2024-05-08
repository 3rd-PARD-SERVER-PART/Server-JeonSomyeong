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
//    JPA 에서 Member 엔티티의 PK 값을 자동으로 생성
//    JPA 는 새 엔티티를 저장할 때 PK 값을 지정하지 않고, 데이터베이스에 저장을 요청
//    이후 JPA 는 데이터베이스로부터 할당된 기본 키 값을 받아와 엔티티 객체에 설정
//    ex) MySQL 에서는 AUTO_INCREMENT 속성을 사용하여 기본 키 값을 자동으로 증가시키고 할당
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String part;

    private int age;

//    DTO 를 Entity 로 바꾸는 메서드
    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
