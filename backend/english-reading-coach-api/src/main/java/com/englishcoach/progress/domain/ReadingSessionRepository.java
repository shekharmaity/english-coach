package com.englishcoach.progress.domain;

import java.util.Optional;
import java.util.UUID;

public interface ReadingSessionRepository {
  Optional<ReadingSession> getById(UUID id);

  ReadingSession save(ReadingSession readingSession);

  boolean remove(UUID id);
}
