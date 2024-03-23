package com.pard.first_seminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestAPIController {
    @GetMapping("/{userId}")
    public String hi(@PathVariable Integer userId)
    {
        return "Get 으로 온 컨트롤러" + userId;
    }

    @GetMapping()
    public  String UserAll(){
        return "Get : userAll";
    }

    @PostMapping()
    public String userCreate(){
        return "Post : user Create";
    }

    @PutMapping()
    public String userUpdate(){
        return "Put : user Update";
    }

    @PatchMapping()
    public String userUpdateByPatch(){
        return "Patch : user Update by patch";
    }


    @DeleteMapping()
    public String userDelete(){
        return "Delete : user Delete";
    }
}


