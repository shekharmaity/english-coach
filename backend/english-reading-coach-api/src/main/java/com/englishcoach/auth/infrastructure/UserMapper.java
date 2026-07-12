package com.englishcoach.auth.infrastructure;

import com.englishcoach.auth.domain.User;
import java.util.UUID;

final class UserMapper {
  private UserMapper() {}

  static User toDomain(UserJpaEntity entity) {
    return new User(
        entity.id,
        entity.email,
        entity.passwordHash,
        entity.displayName,
        entity.role,
        entity.emailVerified,
        entity.preferredTimezone,
        entity.createdAt,
        entity.updatedAt);
  }

  static UserJpaEntity toJpa(User user) {
    UserJpaEntity entity = new UserJpaEntity();
    entity.id = user.id() == null ? UUID.randomUUID() : user.id();
    entity.email = user.email();
    entity.passwordHash = user.passwordHash();
    entity.displayName = user.displayName();
    entity.role = user.role();
    entity.emailVerified = user.emailVerified();
    entity.preferredTimezone = user.preferredTimezone();
    entity.createdAt = user.createdAt();
    entity.updatedAt = user.updatedAt();
    return entity;
  }
}
