package com.pard.first_seminar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/index")
    public String hello() {
        return "index.html";
    }
}
