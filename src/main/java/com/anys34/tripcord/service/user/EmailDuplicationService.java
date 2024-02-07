package com.anys34.tripcord.service.user;

import com.anys34.tripcord.dto.user.EmailRequest;
import com.anys34.tripcord.exception.user.UserDuplicateException;
import com.anys34.tripcord.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailDuplicationService {
    private final UserRepository userRepository;

    public void execute(EmailRequest emailRequest) {
        if (userRepository.existsByEmail(emailRequest.getEmail())) {
            throw UserDuplicateException.EXCEPTION;
        }
    }
}
