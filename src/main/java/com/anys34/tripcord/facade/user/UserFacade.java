package com.anys34.tripcord.facade.user;

import com.anys34.tripcord.domain.user.User;
import com.anys34.tripcord.exception.user.UserNotFoundException;
import com.anys34.tripcord.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
public class UserFacade {
    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public Optional<User> findEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
