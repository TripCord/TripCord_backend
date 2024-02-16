package com.anys34.tripcord.dto.user;

import com.anys34.tripcord.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoResponse {
    private String nickname;
    private String email;
    private String profile;

    public UserInfoResponse(User user) {
        nickname = user.getNickname();
        email = user.getEmail();
        profile = user.getProfileImg();
    }
}
