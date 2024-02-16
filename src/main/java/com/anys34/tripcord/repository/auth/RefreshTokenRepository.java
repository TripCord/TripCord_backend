package com.anys34.tripcord.repository.auth;

import com.anys34.tripcord.domain.auth.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}