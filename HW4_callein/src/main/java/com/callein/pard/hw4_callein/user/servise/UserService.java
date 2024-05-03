package com.callein.pard.hw4_callein.user.servise;

import com.callein.pard.hw4_callein.book.entity.Book;
import com.callein.pard.hw4_callein.book.repo.BookRepo;
import com.callein.pard.hw4_callein.user.dto.UserLoanHistoryDTO;
import com.callein.pard.hw4_callein.user.entity.User;
import com.callein.pard.hw4_callein.user.dto.UserDTO;
import com.callein.pard.hw4_callein.user.entity.UserLoanHistory;
import com.callein.pard.hw4_callein.user.repo.UserRepo;
import com.callein.pard.hw4_callein.book.dto.BookReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;


    public void createUser(UserDTO.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public void updateUser(UserDTO.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public List<UserDTO.Read> readAll(){
        // 유저들을 리스트로 가져옴
        // stream 으로 하나씩 나눔
        return userRepo.findAll()
                .stream()
                .map(UserDTO.Read::new)
                .toList();
    }

}
