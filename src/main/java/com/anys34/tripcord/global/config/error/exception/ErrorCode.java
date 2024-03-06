package com.anys34.tripcord.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_DUPLICATE(HttpStatus.BAD_REQUEST, "User Duplicate"), // 유저의 이메일이 중복됨
    USER_INCORRECT(HttpStatus.BAD_REQUEST, "User Incorrect"), // 이메일 혹은 비밀번호가 맞지 않음

    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt"), // 만료된 JWT

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"), // 유저를 찾을 수 없음
    FOLLOW_NOT_FOUND(HttpStatus.NOT_FOUND, "Follow Not Found"), // 팔로우한 기록을 찾을 수 없음

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;
}
