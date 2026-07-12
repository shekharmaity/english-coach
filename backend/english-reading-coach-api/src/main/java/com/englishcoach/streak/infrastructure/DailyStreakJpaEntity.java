package com.englishcoach.streak.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "daily_streaks")
public class DailyStreakJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "user_id", nullable = false)
  public UUID userId;

  @Column(name = "streak_date", nullable = false)
  public LocalDate streakDate;

  @Column(name = "sessions_completed", nullable = false)
  public int sessionsCompleted;

  @Column(name = "words_read", nullable = false)
  public int wordsRead;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
