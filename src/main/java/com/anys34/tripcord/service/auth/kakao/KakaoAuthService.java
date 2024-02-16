package com.anys34.tripcord.service.auth.kakao;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.dto.auth.req.CodeRequest;
import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.facade.user.UserFacade;
import com.anys34.tripcord.global.config.properties.AuthProperties;
import com.anys34.tripcord.global.feign.auth.kakao.KakaoAuthClient;
import com.anys34.tripcord.global.feign.auth.kakao.KakaoInformationClient;
import com.anys34.tripcord.global.feign.auth.kakao.dto.res.KakaoAuthResponse;
import com.anys34.tripcord.global.security.jwt.JwtTokenProvider;
import com.anys34.tripcord.repository.user.UserRepository;
import com.anys34.tripcord.type.user.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KakaoAuthService {
    private final AuthProperties authProperties;
    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoInformationClient kakaoInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(CodeRequest codeRequest) {
        KakaoAuthResponse accessToken = kakaoAuthClient.getAccessToken(
                authProperties.getKakaoClientId(),
                authProperties.getKakaoRedirectUrl(),
                codeRequest.getCode());

        Map<String, Object> response = kakaoInformationClient.getUserInformation("Bearer " + accessToken.getAccess_token());

        Map<String, Object> kakao_account = (Map<String, Object>) response.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");

        String nickname = (String) profile.get("nickname");
        String profile_img = (String) profile.get("profile_image_url");
        String email = (String) kakao_account.get("email");

        Optional<User> user = userFacade.findEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(nickname)
                    .profileImg(profile_img)
                    .provider(Provider.KAKAO)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
