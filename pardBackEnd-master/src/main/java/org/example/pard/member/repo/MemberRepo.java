package org.example.pard.member.repo;

import org.example.pard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JPA 를 사용하여 Member 엔티티에 대한 CRUD 를 할 수 있는 메서드를 제공해줌
public interface MemberRepo extends JpaRepository<Member, Long> {
//   Spring Data JPA 는 메서드 이름을 분석하여 적절한 쿼리를 생성함
   List<Member> findByPart(String part);
}
