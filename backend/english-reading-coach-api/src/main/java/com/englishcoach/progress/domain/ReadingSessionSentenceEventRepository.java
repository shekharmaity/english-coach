package com.englishcoach.progress.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReadingSessionSentenceEventRepository {
  Optional<ReadingSessionSentenceEvent> getById(UUID id);

  List<ReadingSessionSentenceEvent> listByReadingSession(UUID readingSessionId);

  ReadingSessionSentenceEvent save(ReadingSessionSentenceEvent event);

  boolean remove(UUID id);
}
