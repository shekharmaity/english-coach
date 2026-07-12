package com.englishcoach.progress.dto;

import com.englishcoach.progress.domain.ProgressStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record UserLessonProgressResponse(
    UUID id,
    UUID userId,
    UUID lessonId,
    ProgressStatus status,
    BigDecimal completionPercent,
    Integer lastSentencePosition,
    Integer lastSpeedWpm,
    Instant startedAt,
    Instant completedAt) {}
