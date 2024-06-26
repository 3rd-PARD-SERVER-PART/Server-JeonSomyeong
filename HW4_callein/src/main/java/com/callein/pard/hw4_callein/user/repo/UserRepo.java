package com.callein.pard.hw4_callein.user.repo;

import com.callein.pard.hw4_callein.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}