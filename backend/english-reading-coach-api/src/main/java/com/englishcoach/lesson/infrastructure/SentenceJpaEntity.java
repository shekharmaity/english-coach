package com.englishcoach.lesson.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "sentences")
public class SentenceJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "lesson_id", nullable = false)
  public UUID lessonId;

  @Column(nullable = false)
  public int position;

  @Column(nullable = false)
  public String content;

  @Column(name = "word_count", nullable = false)
  public int wordCount;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
