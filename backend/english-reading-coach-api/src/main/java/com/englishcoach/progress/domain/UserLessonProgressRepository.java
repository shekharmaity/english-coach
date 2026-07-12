package com.englishcoach.progress.domain;

import java.util.Optional;
import java.util.UUID;

public interface UserLessonProgressRepository {
  Optional<UserLessonProgress> getById(UUID id);

  Optional<UserLessonProgress> getByUserAndLesson(UUID userId, UUID lessonId);

  UserLessonProgress save(UserLessonProgress progress);

  boolean remove(UUID id);
}
