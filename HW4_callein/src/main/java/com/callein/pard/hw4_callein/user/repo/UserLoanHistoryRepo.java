package com.callein.pard.hw4_callein.user.repo;


import com.callein.pard.hw4_callein.user.entity.User;
import com.callein.pard.hw4_callein.user.entity.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanHistoryRepo extends JpaRepository<UserLoanHistory, Long> {
}