package com.englishcoach.lesson.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SentenceRepository {
  Optional<Sentence> getById(UUID id);

  List<Sentence> listByLesson(UUID lessonId);

  Sentence save(Sentence sentence);

  boolean remove(UUID id);
}
