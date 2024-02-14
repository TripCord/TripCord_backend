package com.anys34.tripcord.dto.auth.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CodeRequest {
    @NotNull(message = "code가 비었습니다.")
    private String code;
}
