package com.englishcoach.progress.dto;

import com.englishcoach.progress.domain.ReadingSessionStatus;
import java.time.Instant;
import java.util.UUID;

public record ReadingSessionResponse(
    UUID id,
    UUID userId,
    UUID lessonId,
    ReadingSessionStatus status,
    int speedWpm,
    int elapsedSeconds,
    int wordsRead,
    Instant startedAt,
    Instant completedAt,
    String clientPlatform) {}
