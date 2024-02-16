package com.anys34.tripcord.global.security.jwt.exception;

import com.anys34.tripcord.global.config.error.exception.BusinessException;
import com.anys34.tripcord.global.config.error.exception.ErrorCode;

public class ExpiredJwtException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}