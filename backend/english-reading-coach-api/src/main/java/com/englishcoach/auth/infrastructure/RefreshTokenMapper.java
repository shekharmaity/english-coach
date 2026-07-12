package com.englishcoach.auth.infrastructure;

import com.englishcoach.auth.domain.RefreshToken;
import java.util.UUID;

final class RefreshTokenMapper {
  private RefreshTokenMapper() {}

  static RefreshToken toDomain(RefreshTokenJpaEntity entity) {
    return new RefreshToken(
        entity.id,
        entity.userId,
        entity.tokenHash,
        entity.expiresAt,
        entity.revokedAt,
        entity.createdAt);
  }

  static RefreshTokenJpaEntity toJpa(RefreshToken refreshToken) {
    RefreshTokenJpaEntity entity = new RefreshTokenJpaEntity();
    entity.id = refreshToken.id() == null ? UUID.randomUUID() : refreshToken.id();
    entity.userId = refreshToken.userId();
    entity.tokenHash = refreshToken.tokenHash();
    entity.expiresAt = refreshToken.expiresAt();
    entity.revokedAt = refreshToken.revokedAt();
    entity.createdAt = refreshToken.createdAt();
    return entity;
  }
}
