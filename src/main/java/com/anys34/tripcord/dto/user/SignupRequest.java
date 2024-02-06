package com.anys34.tripcord.dto.user;

import com.anys34.tripcord.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotNull(message = "이메일이 비어있습니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @Size(min = 2, max = 10, message = "닉네임은 2~10자리이여야 합니다.")
    @NotNull(message = "닉네임이 비어있습니다.")
    private String nickname;
    @NotNull(message = "비밀번호가 비어있습니다.")
    private String password;

    public User toEntity() {
        return new User(email, nickname, password);
    }

    public void passwordUpdate(String password) {
        this.password = password;
    }
}
