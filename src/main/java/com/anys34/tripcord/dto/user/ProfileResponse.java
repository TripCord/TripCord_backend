package com.anys34.tripcord.dto.user;

import com.anys34.tripcord.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {
    private String email;
    private String nickname;

    public ProfileResponse(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
