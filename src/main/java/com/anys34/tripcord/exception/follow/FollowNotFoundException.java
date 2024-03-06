package com.anys34.tripcord.exception.follow;

import com.anys34.tripcord.global.config.error.exception.BusinessException;
import com.anys34.tripcord.global.config.error.exception.ErrorCode;

public class FollowNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new FollowNotFoundException();

    private FollowNotFoundException() { super(ErrorCode.FOLLOW_NOT_FOUND); }
}
