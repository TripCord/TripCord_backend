package com.anys34.tripcord.service.follow;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.follow.AddFollowRequest;
import com.anys34.tripcord.exception.follow.FollowDuplicateException;
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
    public void execute(AddFollowRequest request) {
        String email = request.getEmail();

        if(userFacade.getUserByEmail(email) == null) throw UserNotFoundException.EXCEPTION;
        if(userFacade.getCurrentUser().getEmail().equals(email)) throw UserDuplicateException.EXCEPTION;

        String toUser = userFacade.getCurrentUser().getEmail();
        User fromUser = userFacade.getUserByEmail(email);

        if(followRepository.existsByToUserAndFromUser(toUser, fromUser)) throw FollowDuplicateException.EXCEPTION;

        followRepository.save(request.toEntity(toUser, fromUser));
    }
}