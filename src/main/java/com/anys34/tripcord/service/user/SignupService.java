package com.anys34.tripcord.service.user;

import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.dto.user.SignupRequest;
import com.anys34.tripcord.global.security.jwt.JwtTokenProvider;
import com.anys34.tripcord.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(SignupRequest signupRequest) {
        signupRequest.passwordUpdate(passwordEncoder.encode(signupRequest.getPassword()));
        String email = signupRequest.getEmail();

        userRepository.save(signupRequest.toEntity());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
