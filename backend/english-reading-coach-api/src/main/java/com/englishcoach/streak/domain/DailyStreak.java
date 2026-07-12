package com.englishcoach.streak.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record DailyStreak(
    UUID id,
    UUID userId,
    LocalDate streakDate,
    int sessionsCompleted,
    int wordsRead,
    Instant createdAt,
    Instant updatedAt) {}
