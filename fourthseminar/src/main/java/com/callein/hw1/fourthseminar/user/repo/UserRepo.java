package com.callein.hw1.fourthseminar.user.repo;

import com.callein.hw1.fourthseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
