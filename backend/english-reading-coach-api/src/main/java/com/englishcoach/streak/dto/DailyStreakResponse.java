package com.englishcoach.streak.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DailyStreakResponse(
    UUID id, UUID userId, LocalDate streakDate, int sessionsCompleted, int wordsRead) {}
