package com.anys34.tripcord.service.auth.google;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.facade.user.UserFacade;
import com.anys34.tripcord.global.feign.auth.google.GoogleInformationClient;
import com.anys34.tripcord.global.feign.auth.google.dto.res.GoogleInformationResponse;
import com.anys34.tripcord.global.security.jwt.JwtTokenProvider;
import com.anys34.tripcord.repository.user.UserRepository;
import com.anys34.tripcord.type.user.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {
    private final GoogleInformationClient googleInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(String accessToken) {
        GoogleInformationResponse response = googleInformationClient
                .getUserInformation(accessToken);
        String email = response.getEmail();

        Optional<User> user = userFacade.findEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(response.getName())
                    .profileImg(response.getPicture())
                    .provider(Provider.GOOGLE)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
