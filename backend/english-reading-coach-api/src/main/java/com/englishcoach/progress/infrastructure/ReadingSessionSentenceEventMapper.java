package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ReadingSessionSentenceEvent;
import java.util.UUID;

final class ReadingSessionSentenceEventMapper {
  private ReadingSessionSentenceEventMapper() {}

  static ReadingSessionSentenceEvent toDomain(ReadingSessionSentenceEventJpaEntity entity) {
    return new ReadingSessionSentenceEvent(
        entity.id,
        entity.readingSessionId,
        entity.sentenceId,
        entity.sentencePosition,
        entity.elapsedSeconds,
        entity.wordsRead,
        entity.startedAt,
        entity.completedAt,
        entity.createdAt);
  }

  static ReadingSessionSentenceEventJpaEntity toJpa(ReadingSessionSentenceEvent event) {
    ReadingSessionSentenceEventJpaEntity entity = new ReadingSessionSentenceEventJpaEntity();
    entity.id = event.id() == null ? UUID.randomUUID() : event.id();
    entity.readingSessionId = event.readingSessionId();
    entity.sentenceId = event.sentenceId();
    entity.sentencePosition = event.sentencePosition();
    entity.elapsedSeconds = event.elapsedSeconds();
    entity.wordsRead = event.wordsRead();
    entity.startedAt = event.startedAt();
    entity.completedAt = event.completedAt();
    entity.createdAt = event.createdAt();
    return entity;
  }
}
