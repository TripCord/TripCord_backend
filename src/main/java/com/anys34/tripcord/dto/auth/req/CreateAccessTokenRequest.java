package com.anys34.tripcord.dto.auth.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAccessTokenRequest {
    @NotNull(message = "refreshToken이 비었습니다.")
    private String refreshToken;
}
