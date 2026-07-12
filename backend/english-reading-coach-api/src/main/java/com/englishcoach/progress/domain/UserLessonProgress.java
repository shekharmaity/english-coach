package com.englishcoach.progress.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record UserLessonProgress(
    UUID id,
    UUID userId,
    UUID lessonId,
    ProgressStatus status,
    BigDecimal completionPercent,
    Integer lastSentencePosition,
    Integer lastSpeedWpm,
    Instant startedAt,
    Instant completedAt,
    Instant updatedAt) {}
