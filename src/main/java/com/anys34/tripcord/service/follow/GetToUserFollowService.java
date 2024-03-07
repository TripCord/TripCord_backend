package com.anys34.tripcord.service.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.dto.follow.FollowResponse;
import com.anys34.tripcord.exception.user.UserNotFoundException;
import com.anys34.tripcord.facade.user.UserFacade;
import com.anys34.tripcord.repository.follow.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetToUserFollowService {
    private final FollowRepository followRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<FollowResponse> execute(String email) {
        if(email == null || userFacade.getUserByEmail(email) == null) throw UserNotFoundException.EXCEPTION;
        String user = userFacade.getUserByEmail(email).getEmail();

        List<FollowResponse> follows = followRepository.findAllByToUser(user)
                .stream()
                .map(FollowResponse::new)
                .collect(Collectors.toList());

        return follows;
    }
}