package org.example.pard.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.pard.member.dto.MemberCreateDTO;
import org.example.pard.member.dto.MemberReadDTO;
import org.example.pard.member.service.MemberService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 컨트롤러는 클라이언트로부터 요청을 받아들이고, 필요한 비즈니스 로직을 서비스 계층에 위임
// 최종적으로 뷰를 렌더링하거나 응답 데이터를 생성

// 이 컨트롤러가 RESTful 한 웹 서비스를 제공하는 역할을 한다는 것을 명시
@RestController
@RequiredArgsConstructor
// 이 컨트롤러의 기본 URL 경로를 '/pard' 로 지정
@RequestMapping("/pard")
public class MemberController {
//    서비스 객체를 사용, DTO 로 데이터를 주고받아 계층을 분리하고, 계층간의 낮은 결합도를 유지
    private final MemberService memberService;

//    @RestController 어노테이션이 적용되어 있기 때문에, 메서드의 리턴값이 자동으로 HTTP 응답 본문에 포함됨
//    Spring 은 리턴값을 JSON 또는 XML 과 같은 형식으로 직렬화하여 클라이언트에 전송

    @PostMapping("")
    public String createMember(@RequestBody MemberCreateDTO dto) {
        memberService.createMember(dto);
        return "파드에 가입을 축하드립니다.";
    }

    @GetMapping("")
    public List<MemberReadDTO> findMember(@RequestParam(required = false) String part) {
//        part 문자열이 null 이 아니고, 빈 문자열이 아닌 경우 true 반환
        if (StringUtils.hasText(part)) {
//            part 문자열에 문자가 있으면, part 기준으로 검색
            return memberService.findByPart(part);
        }
//        part 문자열에 아무 것도 전달되지 않았으면, 전부 검색
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
