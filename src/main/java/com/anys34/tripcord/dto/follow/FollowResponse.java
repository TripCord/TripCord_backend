package com.anys34.tripcord.dto.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.domain.user.User;
import lombok.Getter;

@Getter
public class FollowResponse {
    private final String toUser;
    private final User fromUser;

    public FollowResponse(Follow follow) {
        this.toUser = follow.getToUser();
        this.fromUser = follow.getFromUser();
    }
}
