package com.englishcoach.streak.infrastructure;

import com.englishcoach.streak.domain.DailyStreak;
import java.util.UUID;

final class DailyStreakMapper {
  private DailyStreakMapper() {}

  static DailyStreak toDomain(DailyStreakJpaEntity entity) {
    return new DailyStreak(
        entity.id,
        entity.userId,
        entity.streakDate,
        entity.sessionsCompleted,
        entity.wordsRead,
        entity.createdAt,
        entity.updatedAt);
  }

  static DailyStreakJpaEntity toJpa(DailyStreak dailyStreak) {
    DailyStreakJpaEntity entity = new DailyStreakJpaEntity();
    entity.id = dailyStreak.id() == null ? UUID.randomUUID() : dailyStreak.id();
    entity.userId = dailyStreak.userId();
    entity.streakDate = dailyStreak.streakDate();
    entity.sessionsCompleted = dailyStreak.sessionsCompleted();
    entity.wordsRead = dailyStreak.wordsRead();
    entity.createdAt = dailyStreak.createdAt();
    entity.updatedAt = dailyStreak.updatedAt();
    return entity;
  }
}
