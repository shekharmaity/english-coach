package com.englishcoach.auth.domain;

import java.time.Instant;
import java.util.UUID;

public record User(
    UUID id,
    String email,
    String passwordHash,
    String displayName,
    UserRole role,
    boolean emailVerified,
    String preferredTimezone,
    Instant createdAt,
    Instant updatedAt) {}
