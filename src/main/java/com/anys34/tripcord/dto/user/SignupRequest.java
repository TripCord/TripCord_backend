package com.anys34.tripcord.dto.user;

import com.anys34.tripcord.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;
    private String nickname;
    private String password;

    public User toEntity() {
        return new User(email, nickname, password);
    }

    public void passwordUpdate(String password) {
        this.password = password;
    }
}
