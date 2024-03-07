package com.anys34.tripcord.exception.follow;

import com.anys34.tripcord.global.config.error.exception.BusinessException;
import com.anys34.tripcord.global.config.error.exception.ErrorCode;

public class FollowDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new FollowDuplicateException();

    private FollowDuplicateException() { super(ErrorCode.FOLLOW_DUPLICATE); }
}
