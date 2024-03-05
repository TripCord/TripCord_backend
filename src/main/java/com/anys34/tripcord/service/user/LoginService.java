package com.anys34.tripcord.service.user;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.dto.user.LoginRequest;
import com.anys34.tripcord.dto.user.ProfileResponse;
import com.anys34.tripcord.exception.user.UserIncorrectException;
import com.anys34.tripcord.facade.user.UserFacade;
import com.anys34.tripcord.global.security.jwt.JwtTokenProvider;
import com.anys34.tripcord.type.user.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public TokenResponse execute(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        User user = userFacade.getUserByEmail(email);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw UserIncorrectException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
