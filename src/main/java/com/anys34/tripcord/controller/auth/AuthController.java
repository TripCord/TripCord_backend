package com.anys34.tripcord.controller.auth;

import com.anys34.tripcord.dto.auth.req.CreateAccessTokenRequest;
import com.anys34.tripcord.dto.auth.res.AccessTokenResponse;
import com.anys34.tripcord.service.auth.CreateAccessTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final CreateAccessTokenService createNewAccessToken;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AccessTokenResponse createNewAccessToken(@RequestBody @Valid CreateAccessTokenRequest request) {
        return createNewAccessToken.execute(request.getRefreshToken());
    }
}
