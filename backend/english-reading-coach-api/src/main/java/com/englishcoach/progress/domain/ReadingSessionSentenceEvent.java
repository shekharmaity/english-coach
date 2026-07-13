package com.englishcoach.progress.domain;

import java.time.Instant;
import java.util.UUID;

public record ReadingSessionSentenceEvent(
    UUID id,
    UUID readingSessionId,
    UUID sentenceId,
    int sentencePosition,
    int elapsedSeconds,
    int wordsRead,
    Instant startedAt,
    Instant completedAt,
    Instant createdAt) {}
