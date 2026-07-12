package com.englishcoach.lesson.domain;

import java.time.Instant;
import java.util.UUID;

public record Lesson(
    UUID id,
    UUID categoryId,
    String slug,
    String title,
    String description,
    LessonDifficulty difficulty,
    int estimatedSeconds,
    int defaultSpeedWpm,
    boolean published,
    int sortOrder,
    Instant createdAt,
    Instant updatedAt) {}
