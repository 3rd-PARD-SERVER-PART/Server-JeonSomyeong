package com.callein.pard.hw5_callein.user.controller;

import com.callein.pard.hw5_callein.user.dto.UserLoanHistoryDTO;
import com.callein.pard.hw5_callein.user.servise.UserLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class UserLoanController {
    private final UserLoanService userLoanService;

    @GetMapping("/list")
    public List<UserLoanHistoryDTO.Read> findAll(){
        return  userLoanService.findAll();
    }

    @PostMapping("/request")
    public String requestLoan(@RequestBody UserLoanHistoryDTO.Create dto){
        return userLoanService.requestLoan(dto);
    }

    @PostMapping("/return")
    public String requestReturn(@RequestBody UserLoanHistoryDTO.Create dto){
        return userLoanService.requestReturn(dto);
    }
}
