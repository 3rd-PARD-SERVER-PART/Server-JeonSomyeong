package org.example.pard.member.service;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.entity.Member;
import org.example.pard.member.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;

    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    }

    public MemberReadDTO findById(Long id) {
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
    }

    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    public List<MemberReadDTO> findByPart(String part) {
        return memberRepo.findByPart(part)
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }


}
