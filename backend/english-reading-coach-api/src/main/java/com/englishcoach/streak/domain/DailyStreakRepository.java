package com.englishcoach.streak.domain;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface DailyStreakRepository {
  Optional<DailyStreak> getById(UUID id);

  Optional<DailyStreak> getByUserAndDate(UUID userId, LocalDate streakDate);

  DailyStreak save(DailyStreak dailyStreak);

  boolean remove(UUID id);
}
