package com.anys34.tripcord.controller.user;

import com.anys34.tripcord.dto.user.EmailRequest;
import com.anys34.tripcord.dto.user.LoginRequest;
import com.anys34.tripcord.dto.user.ProfileResponse;
import com.anys34.tripcord.dto.user.SignupRequest;
import com.anys34.tripcord.service.user.EmailDuplicationService;
import com.anys34.tripcord.service.user.LoginService;
import com.anys34.tripcord.service.user.SignupService;
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

    @PostMapping("/login")
    public ProfileResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.execute(loginRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignupRequest signUpRequest) {
        signupService.execute(signUpRequest);
    }

    @PostMapping("/email")
    public void checkEmail(@RequestBody @Valid EmailRequest emailRequest) {
        emailDuplicationService.execute(emailRequest);
    }
}
