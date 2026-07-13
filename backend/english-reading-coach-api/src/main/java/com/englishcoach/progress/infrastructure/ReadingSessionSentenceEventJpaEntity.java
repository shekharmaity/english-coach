package com.englishcoach.progress.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "reading_session_sentence_events")
public class ReadingSessionSentenceEventJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "reading_session_id", nullable = false)
  public UUID readingSessionId;

  @Column(name = "sentence_id", nullable = false)
  public UUID sentenceId;

  @Column(name = "sentence_position", nullable = false)
  public int sentencePosition;

  @Column(name = "elapsed_seconds", nullable = false)
  public int elapsedSeconds;

  @Column(name = "words_read", nullable = false)
  public int wordsRead;

  @Column(name = "started_at", nullable = false)
  public Instant startedAt;

  @Column(name = "completed_at")
  public Instant completedAt;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;
}
