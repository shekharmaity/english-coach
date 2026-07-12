package com.englishcoach.category.domain;

import java.time.Instant;
import java.util.UUID;

public record Category(
    UUID id,
    String slug,
    String title,
    String description,
    int sortOrder,
    boolean active,
    Instant createdAt,
    Instant updatedAt) {}
