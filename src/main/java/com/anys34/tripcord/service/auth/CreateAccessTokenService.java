package com.anys34.tripcord.service.auth;

import com.anys34.tripcord.domain.auth.RefreshToken;
import com.anys34.tripcord.dto.auth.res.AccessTokenResponse;
import com.anys34.tripcord.global.security.jwt.JwtTokenProvider;
import com.anys34.tripcord.global.security.jwt.exception.ExpiredJwtException;
import com.anys34.tripcord.repository.auth.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccessTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return new AccessTokenResponse(jwtTokenProvider
                .createAccessToken(refreshToken.getEmail()));
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token)
                .orElseThrow(() -> ExpiredJwtException.EXCEPTION);
    }
}
