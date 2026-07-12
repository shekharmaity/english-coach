package com.englishcoach.lesson.domain;

import java.time.Instant;
import java.util.UUID;

public record Sentence(
    UUID id,
    UUID lessonId,
    int position,
    String content,
    int wordCount,
    Instant createdAt,
    Instant updatedAt) {}
