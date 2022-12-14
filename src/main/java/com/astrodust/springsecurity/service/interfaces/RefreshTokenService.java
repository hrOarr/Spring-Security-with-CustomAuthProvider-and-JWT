package com.astrodust.springsecurity.service.interfaces;

import com.astrodust.springsecurity.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);
    RefreshToken createRefreshToken(String username);
    RefreshToken verifyExpiration(RefreshToken token);
    void deleteByUserId(int userId);
}
