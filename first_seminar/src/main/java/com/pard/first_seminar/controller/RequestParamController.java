package com.pard.first_seminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.color.ICC_ColorSpace;
import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(@RequestParam("name") String name,
                               @RequestParam("age") int age
                               ){
        return "requestParam 연습 \n name: " + name + "\n age: " + age;
    }
    @RequestMapping("/V2")
    public String requestParamV2(
            @RequestParam String name,
            @RequestParam int age
    ){
        return "V2"+name+age;
    }
    @RequestMapping("/V3")
    public String requestParamV3(
            String name,
            int age
    ){
        return "V3"+name+age;
    }
    @RequestMapping("/V4")
    public String requestParamV4(
            @RequestParam(defaultValue = "questKKKKK") String name,
            @RequestParam(required =false, defaultValue = "99999") int age
    ){
        return "V4"+name+age;
    }

    @RequestMapping("/default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String name,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        return "requestParamV5 연습 name : " + name + " age : " + age;
    }
    @RequestMapping("/map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        return "requestParamV6 연습 name : " + paramMap.get("name") + " age : " + paramMap.get("age");
    }
}
