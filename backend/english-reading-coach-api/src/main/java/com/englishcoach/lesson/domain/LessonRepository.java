package com.englishcoach.lesson.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonRepository {
  Optional<Lesson> getById(UUID id);

  Optional<Lesson> getBySlug(String slug);

  List<Lesson> listPublishedByCategory(UUID categoryId);

  Lesson save(Lesson lesson);

  boolean remove(UUID id);
}
