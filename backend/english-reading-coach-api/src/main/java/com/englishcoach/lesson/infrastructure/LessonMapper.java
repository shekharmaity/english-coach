package com.englishcoach.lesson.infrastructure;

import com.englishcoach.lesson.domain.Lesson;
import java.util.UUID;

final class LessonMapper {
  private LessonMapper() {}

  static Lesson toDomain(LessonJpaEntity entity) {
    return new Lesson(
        entity.id,
        entity.categoryId,
        entity.slug,
        entity.title,
        entity.description,
        entity.difficulty,
        entity.estimatedSeconds,
        entity.defaultSpeedWpm,
        entity.published,
        entity.sortOrder,
        entity.createdAt,
        entity.updatedAt);
  }

  static LessonJpaEntity toJpa(Lesson lesson) {
    LessonJpaEntity entity = new LessonJpaEntity();
    entity.id = lesson.id() == null ? UUID.randomUUID() : lesson.id();
    entity.categoryId = lesson.categoryId();
    entity.slug = lesson.slug();
    entity.title = lesson.title();
    entity.description = lesson.description();
    entity.difficulty = lesson.difficulty();
    entity.estimatedSeconds = lesson.estimatedSeconds();
    entity.defaultSpeedWpm = lesson.defaultSpeedWpm();
    entity.published = lesson.published();
    entity.sortOrder = lesson.sortOrder();
    entity.createdAt = lesson.createdAt();
    entity.updatedAt = lesson.updatedAt();
    return entity;
  }
}
