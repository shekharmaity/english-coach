package com.englishcoach.statistics.domain;

import java.util.UUID;

public record ReadingStats(
    UUID userId, long completedLessons, long completedSessions, long totalWordsRead) {}
