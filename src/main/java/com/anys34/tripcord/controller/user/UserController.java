package com.anys34.tripcord.controller.user;

import com.anys34.tripcord.dto.user.LoginRequest;
import com.anys34.tripcord.dto.user.ProfileResponse;
import com.anys34.tripcord.dto.user.SignupRequest;
import com.anys34.tripcord.service.user.LoginService;
import com.anys34.tripcord.service.user.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;

    @PostMapping("/login")
    public ProfileResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.execute(loginRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequest signUpRequest) {
        signupService.execute(signUpRequest);
    }
}