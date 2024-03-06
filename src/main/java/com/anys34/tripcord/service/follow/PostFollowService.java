package com.anys34.tripcord.service.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.exception.user.UserDuplicateException;
import com.anys34.tripcord.exception.user.UserNotFoundException;
import com.anys34.tripcord.facade.user.UserFacade;
import com.anys34.tripcord.repository.follow.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostFollowService {
    private final FollowRepository followRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(String email) {
        if(userFacade.getUserByEmail(email) == null) throw UserNotFoundException.EXCEPTION;
        if(userFacade.getCurrentUser().getEmail().equals(email)) throw UserDuplicateException.EXCEPTION;
        followRepository.save(new Follow(userFacade.getCurrentUser().getEmail(), userFacade.getUserByEmail(email)));
    }
}