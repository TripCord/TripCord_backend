package com.anys34.tripcord.controller.user;

import com.anys34.tripcord.dto.auth.res.TokenResponse;
import com.anys34.tripcord.dto.user.*;
import com.anys34.tripcord.service.user.EmailDuplicationService;
import com.anys34.tripcord.service.user.LoginService;
import com.anys34.tripcord.service.user.SignupService;
import com.anys34.tripcord.service.user.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;
    private final EmailDuplicationService emailDuplicationService;
    private final UserInfoService userInfoService;

    @GetMapping
    public UserInfoResponse profile() {
        return userInfoService.execute();
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.execute(loginRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignupRequest signUpRequest) {
        return signupService.execute(signUpRequest);
    }

    @PostMapping("/email")
    public void checkEmail(@RequestBody @Valid EmailRequest emailRequest) {
        emailDuplicationService.execute(emailRequest);
    }
}
