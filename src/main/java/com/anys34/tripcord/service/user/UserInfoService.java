package com.anys34.tripcord.service.user;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.user.UserInfoResponse;
import com.anys34.tripcord.facade.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserFacade userFacade;

    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserInfoResponse(user);
    }
}
