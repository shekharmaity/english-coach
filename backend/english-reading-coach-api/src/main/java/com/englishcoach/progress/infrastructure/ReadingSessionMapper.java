package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ReadingSession;
import java.util.UUID;

final class ReadingSessionMapper {
  private ReadingSessionMapper() {}

  static ReadingSession toDomain(ReadingSessionJpaEntity entity) {
    return new ReadingSession(
        entity.id,
        entity.userId,
        entity.lessonId,
        entity.status,
        entity.speedWpm,
        entity.elapsedSeconds,
        entity.wordsRead,
        entity.startedAt,
        entity.completedAt,
        entity.clientPlatform);
  }

  static ReadingSessionJpaEntity toJpa(ReadingSession readingSession) {
    ReadingSessionJpaEntity entity = new ReadingSessionJpaEntity();
    entity.id = readingSession.id() == null ? UUID.randomUUID() : readingSession.id();
    entity.userId = readingSession.userId();
    entity.lessonId = readingSession.lessonId();
    entity.status = readingSession.status();
    entity.speedWpm = readingSession.speedWpm();
    entity.elapsedSeconds = readingSession.elapsedSeconds();
    entity.wordsRead = readingSession.wordsRead();
    entity.startedAt = readingSession.startedAt();
    entity.completedAt = readingSession.completedAt();
    entity.clientPlatform = readingSession.clientPlatform();
    return entity;
  }
}
