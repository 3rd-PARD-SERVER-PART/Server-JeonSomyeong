package com.callein.pard.hw5_callein.user.controller;

import com.callein.pard.hw5_callein.user.dto.UserDTO;
import com.callein.pard.hw5_callein.user.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String createUser(@RequestBody UserDTO.Create dto){
        userService.createUser(dto);
        return "유저 추가됨";
    }

    @GetMapping("")
    public List<UserDTO.Read> readAll(){
        return userService.readAll();
    }

    @GetMapping("/{userId}")
    public UserDTO.Read readById(@PathVariable Long userId){ return userService.readById(userId); }
}
