package com.englishcoach.statistics.dto;

import java.util.UUID;

public record ReadingStatsResponse(
    UUID userId, long completedLessons, long completedSessions, long totalWordsRead) {}
