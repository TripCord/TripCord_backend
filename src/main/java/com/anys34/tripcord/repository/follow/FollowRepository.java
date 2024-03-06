package com.anys34.tripcord.repository.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<List<Follow>> findAllByToUser(String toUser);
    Optional<List<Follow>> findAllByFromUser(User fromUser);
    void deleteByToUserAndFromUser(String toUser, User fromUser);
    boolean existsByToUserAndFromUser(String toUser, User fromUser);
}