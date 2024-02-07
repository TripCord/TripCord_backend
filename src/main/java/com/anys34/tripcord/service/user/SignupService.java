package com.anys34.tripcord.service.user;

import com.anys34.tripcord.dto.user.SignupRequest;
import com.anys34.tripcord.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupRequest signupRequest) {
        signupRequest.passwordUpdate(passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(signupRequest.toEntity());
    }
}
