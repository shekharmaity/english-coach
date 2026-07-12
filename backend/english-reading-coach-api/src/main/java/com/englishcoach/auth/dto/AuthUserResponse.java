package com.englishcoach.auth.dto;

import com.englishcoach.auth.domain.UserRole;
import java.util.UUID;

public record AuthUserResponse(
    UUID id, String email, String displayName, UserRole role, boolean emailVerified) {}
