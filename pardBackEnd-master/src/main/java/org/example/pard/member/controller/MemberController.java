package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pard")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    @GetMapping("")
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
        if (StringUtils.hasText(part)) {
            return memberService.findByPart(part);
        }

        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberReadDTO findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "삭제됨";
    }
}
