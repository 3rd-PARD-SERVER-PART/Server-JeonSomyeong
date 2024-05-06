package com.callein.pard.hw5_callein.user.servise;

import com.callein.pard.hw5_callein.book.dto.BookReadDTO;
import com.callein.pard.hw5_callein.user.dto.UserDTO;
import com.callein.pard.hw5_callein.user.dto.UserLoanHistoryDTO;
import com.callein.pard.hw5_callein.user.entity.User;
import com.callein.pard.hw5_callein.user.repo.UserLoanHistoryRepo;
import com.callein.pard.hw5_callein.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final UserLoanHistoryRepo userLoanHistoryRepo;


    public void createUser(UserDTO.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public void updateUser(UserDTO.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public UserDTO.Read readById(Long userId){
        User user = userRepo.findById(userId).orElseThrow();
        List<UserLoanHistoryDTO.Read> histories = findHistoryById(userId);
        return new UserDTO.Read(user, histories);
    }

    public List<UserLoanHistoryDTO.Read> findHistoryById(Long userID){
        return userLoanHistoryRepo.findAll()
                .stream()
                .map(history -> {
                    if(Objects.equals(userID, history.getUser().getUserId())){
                        return new UserLoanHistoryDTO.Read(history,
                                new UserDTO.Read(history.getUser()),
                                new BookReadDTO(history.getBook()));
                    }
                    else return null;
                })
                .toList();
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
