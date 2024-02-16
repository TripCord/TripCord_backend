package com.anys34.tripcord.dto.auth.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessTokenRequest {
    @NotNull(message = "accessToken이 비었습니다.")
    private String accessToken;
}
