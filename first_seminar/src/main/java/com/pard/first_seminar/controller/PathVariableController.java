package com.pard.first_seminar.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path/{name}")
    public String pathVariable(@PathVariable("name") String name) {
        return "PathVariable 연습 name: " + name;
    }
    @RequestMapping("/pathV2/{name}")
    public String pathV2(@PathVariable("name") String name) {
        return "PathVariable 연습 name: " + name;
    }
    @RequestMapping("/pathV3/{name}/{age}")
    public String pathV3(@PathVariable("name") String name, @PathVariable("age") int age) {
        return "PathVariable 다중 연습 name: " + name + "\nage: "+age;
    }
}
