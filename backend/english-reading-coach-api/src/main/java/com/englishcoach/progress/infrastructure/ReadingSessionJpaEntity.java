package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ReadingSessionStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "reading_sessions")
public class ReadingSessionJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "user_id", nullable = false)
  public UUID userId;

  @Column(name = "lesson_id", nullable = false)
  public UUID lessonId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public ReadingSessionStatus status;

  @Column(name = "speed_wpm", nullable = false)
  public int speedWpm;

  @Column(name = "elapsed_seconds", nullable = false)
  public int elapsedSeconds;

  @Column(name = "words_read", nullable = false)
  public int wordsRead;

  @Column(name = "started_at", nullable = false)
  public Instant startedAt;

  @Column(name = "completed_at")
  public Instant completedAt;

  @Column(name = "client_platform", nullable = false)
  public String clientPlatform;
}
