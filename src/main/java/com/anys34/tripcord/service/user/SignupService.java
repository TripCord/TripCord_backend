package com.anys34.tripcord.service.user;

import com.anys34.tripcord.dto.user.SignupRequest;
import com.anys34.tripcord.exception.user.UserDuplicateException;
import com.anys34.tripcord.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void execute(SignupRequest signupRequest) {
        signupRequest.passwordUpdate(bCryptPasswordEncoder.encode(signupRequest.getPassword()));

        duplicateEmail(signupRequest.getEmail());

        userRepository.save(signupRequest.toEntity());
    }

    private void duplicateEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw UserDuplicateException.EXCEPTION;
        }
    }
}
