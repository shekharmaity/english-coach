package com.englishcoach.lesson.infrastructure;

import com.englishcoach.lesson.domain.LessonDifficulty;
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
@Table(name = "lessons")
public class LessonJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "category_id", nullable = false)
  public UUID categoryId;

  @Column(nullable = false, unique = true)
  public String slug;

  @Column(nullable = false)
  public String title;

  @Column(nullable = false)
  public String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public LessonDifficulty difficulty;

  @Column(name = "estimated_seconds", nullable = false)
  public int estimatedSeconds;

  @Column(name = "default_speed_wpm", nullable = false)
  public int defaultSpeedWpm;

  @Column(nullable = false)
  public boolean published;

  @Column(name = "sort_order", nullable = false)
  public int sortOrder;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
