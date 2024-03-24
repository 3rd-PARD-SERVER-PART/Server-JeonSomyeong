package com.callein.hw1.hw1_callein.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


// 아이피 가져와서 바로 user route 로 연결해줄랬는데 view 까지 만들어야해서 그냥 관둠.

@RestController
public class IpController {
    @GetMapping()
    String ip (){
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = req.getRemoteAddr();

        return"현재 아이피 : " + ip;
    }
}
