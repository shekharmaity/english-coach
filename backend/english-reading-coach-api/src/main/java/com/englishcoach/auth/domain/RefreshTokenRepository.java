package com.englishcoach.auth.domain;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository {
  Optional<RefreshToken> getById(UUID id);

  Optional<RefreshToken> getByTokenHash(String tokenHash);

  RefreshToken save(RefreshToken refreshToken);

  boolean remove(UUID id);
}
