package com.anys34.tripcord.service.user;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.user.LoginRequest;
import com.anys34.tripcord.dto.user.ProfileResponse;
import com.anys34.tripcord.exception.user.UserIncorrectException;
import com.anys34.tripcord.facade.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public ProfileResponse execute(LoginRequest loginRequest) {
        User user = userFacade.getUserByEmail(loginRequest.getEmail());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw UserIncorrectException.EXCEPTION;
        }

        return new ProfileResponse(user);
    }
}
