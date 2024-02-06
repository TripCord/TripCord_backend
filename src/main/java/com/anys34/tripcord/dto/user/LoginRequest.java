package com.anys34.tripcord.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

    public void passwordUpdate(String password) {
        this.password = password;
    }
}
