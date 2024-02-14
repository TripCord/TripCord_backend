package com.anys34.tripcord.controller.auth;

import com.anys34.tripcord.dto.auth.req.CodeRequest;
import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.service.auth.kakao.KakaoAuthLinkService;
import com.anys34.tripcord.service.auth.kakao.KakaoAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/kakao")
@RestController
public class KakaoController {
    private final KakaoAuthLinkService kakaoAuthLinkService;
    private final KakaoAuthService kakaoAuthService;

    @GetMapping
    public String getKakaoAuthLink() {
        return kakaoAuthLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody @Valid CodeRequest codeRequest) {
        return kakaoAuthService.execute(codeRequest);
    }
}
