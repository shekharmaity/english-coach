package com.englishcoach.lesson.infrastructure;

import com.englishcoach.lesson.domain.Sentence;
import java.util.UUID;

final class SentenceMapper {
  private SentenceMapper() {}

  static Sentence toDomain(SentenceJpaEntity entity) {
    return new Sentence(
        entity.id,
        entity.lessonId,
        entity.position,
        entity.content,
        entity.wordCount,
        entity.createdAt,
        entity.updatedAt);
  }

  static SentenceJpaEntity toJpa(Sentence sentence) {
    SentenceJpaEntity entity = new SentenceJpaEntity();
    entity.id = sentence.id() == null ? UUID.randomUUID() : sentence.id();
    entity.lessonId = sentence.lessonId();
    entity.position = sentence.position();
    entity.content = sentence.content();
    entity.wordCount = sentence.wordCount();
    entity.createdAt = sentence.createdAt();
    entity.updatedAt = sentence.updatedAt();
    return entity;
  }
}
