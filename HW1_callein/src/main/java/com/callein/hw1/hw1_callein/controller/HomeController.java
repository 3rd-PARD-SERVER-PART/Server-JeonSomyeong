package com.callein.hw1.hw1_callein.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping(value = "/index")
    public String hello() {
        return "index.html";
    }
}
