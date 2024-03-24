package com.callein.hw1.hw1_callein.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    Map<String, Object> my_info =Map.of(
            "name", "전소명",
            "age", 24,
            "department", "AI 컴퓨터 공학 심화",
            "hobby", "탁구"
    );

    public String getMyInfo(){
        return my_info.get("name").toString()+" / "+my_info.get("age").toString()+" / "+my_info.get("department").toString()+" / "+my_info.get("hobby").toString()+"   ";
    }

    public String organizeGuestInfo(String name, Integer age, String department, String hobby){
        return " ||| "+"   "+name+" / "+age+" / "+department+" / "+hobby;
    }
    @GetMapping()
    public String requestUser( @RequestParam(defaultValue = "Anonymous") String name,
                               @RequestParam(defaultValue = "0") Integer age,
                               @RequestParam(defaultValue = "Dept") String department,
                               @RequestParam(defaultValue = "Hobby") String hobby
                               ){
        return getMyInfo() + organizeGuestInfo(name , age, department, hobby);
    }
}
