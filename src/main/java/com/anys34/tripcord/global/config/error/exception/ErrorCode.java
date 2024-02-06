package com.anys34.tripcord.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_DUPLICATE(HttpStatus.BAD_REQUEST, "User Duplicate"),
    USER_INCORRECT(HttpStatus.BAD_REQUEST, "User Incorrect"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;
}
