package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ProgressStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user_lesson_progress")
public class UserLessonProgressJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "user_id", nullable = false)
  public UUID userId;

  @Column(name = "lesson_id", nullable = false)
  public UUID lessonId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public ProgressStatus status;

  @Column(name = "completion_percent", nullable = false)
  public BigDecimal completionPercent;

  @Column(name = "last_sentence_position")
  public Integer lastSentencePosition;

  @Column(name = "last_speed_wpm")
  public Integer lastSpeedWpm;

  @Column(name = "started_at")
  public Instant startedAt;

  @Column(name = "completed_at")
  public Instant completedAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
