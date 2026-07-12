package com.englishcoach.progress.domain;

import java.time.Instant;
import java.util.UUID;

public record ReadingSession(
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
