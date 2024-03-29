package com.anys34.tripcord.dto.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.domain.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddFollowRequest {
    @NotNull(message = "이메일이 비어있습니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    public Follow toEntity(String toUser, User fromUser) {
        return new Follow(toUser, fromUser);
    }
}
