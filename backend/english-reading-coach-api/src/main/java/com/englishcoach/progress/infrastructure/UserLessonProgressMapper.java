package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.UserLessonProgress;
import java.util.UUID;

final class UserLessonProgressMapper {
  private UserLessonProgressMapper() {}

  static UserLessonProgress toDomain(UserLessonProgressJpaEntity entity) {
    return new UserLessonProgress(
        entity.id,
        entity.userId,
        entity.lessonId,
        entity.status,
        entity.completionPercent,
        entity.lastSentencePosition,
        entity.lastSpeedWpm,
        entity.startedAt,
        entity.completedAt,
        entity.updatedAt);
  }

  static UserLessonProgressJpaEntity toJpa(UserLessonProgress progress) {
    UserLessonProgressJpaEntity entity = new UserLessonProgressJpaEntity();
    entity.id = progress.id() == null ? UUID.randomUUID() : progress.id();
    entity.userId = progress.userId();
    entity.lessonId = progress.lessonId();
    entity.status = progress.status();
    entity.completionPercent = progress.completionPercent();
    entity.lastSentencePosition = progress.lastSentencePosition();
    entity.lastSpeedWpm = progress.lastSpeedWpm();
    entity.startedAt = progress.startedAt();
    entity.completedAt = progress.completedAt();
    entity.updatedAt = progress.updatedAt();
    return entity;
  }
}
