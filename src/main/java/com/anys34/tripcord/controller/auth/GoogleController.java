package com.anys34.tripcord.controller.auth;

import com.anys34.tripcord.dto.auth.req.AccessTokenRequest;
import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.service.auth.google.GoogleAuthLinkService;
import com.anys34.tripcord.service.auth.google.GoogleAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/google")
@RestController
public class GoogleController {
    private final GoogleAuthLinkService googleLinkService;
    private final GoogleAuthService googleAuthService;

    @GetMapping
    public String getGoogleAuthLink() {
        return googleLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody @Valid AccessTokenRequest accessTokenRequest) {
        return googleAuthService.execute(accessTokenRequest.getAccessToken());
    }
}
