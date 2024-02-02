package com.anys34.tripcord.repository.user;

import com.anys34.tripcord.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
