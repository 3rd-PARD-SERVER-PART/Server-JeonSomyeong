package org.example.pard.member.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


// 서비스 계층은 비즈니스 로직을 캡슐화하고, 트랜잭션 관리, 보안, 데이터 변환 등의 역할을 수행
// 계층 간의 의존성을 낮추고 응집도를 높여 유지보수성과 확장성을 향상
@Service
@RequiredArgsConstructor
public class MemberService {
//    Repository 의 메서드 사용 위해 객체 생성
    private final MemberRepo memberRepo;

    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    }

    public MemberReadDTO findById(Long id) {
//        Repo 에서 id 로 해당 member 가 존제하는지 확인 후 있다면 엔티티 객체 리턴, 없으면 Exception throw
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
    }

//    JPA 의 repo 에서 모든 member entity 를 조회 후 스트림을 map 을 이용해 DTO 로 변환 후 List 형으로 리턴
    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

//    JPA 의 repo 에서 해당 part 의 member entity 를 조회 후 스트림을 map 을 이용해 DTO 로 변환 후 List 형으로 리턴
    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

//    JPA 의 repo 에서 id 로 해당 entity 를 삭제
    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }
}
