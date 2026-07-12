package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.UserLessonProgress;
import com.englishcoach.progress.domain.UserLessonProgressRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheUserLessonProgressRepository
    implements UserLessonProgressRepository,
        PanacheRepositoryBase<UserLessonProgressJpaEntity, UUID> {
  @Override
  public Optional<UserLessonProgress> getById(UUID id) {
    return findByIdOptional(id).map(UserLessonProgressMapper::toDomain);
  }

  @Override
  public Optional<UserLessonProgress> getByUserAndLesson(UUID userId, UUID lessonId) {
    return find("userId = ?1 and lessonId = ?2", userId, lessonId)
        .firstResultOptional()
        .map(UserLessonProgressMapper::toDomain);
  }

  @Override
  public UserLessonProgress save(UserLessonProgress progress) {
    return UserLessonProgressMapper.toDomain(
        getEntityManager().merge(UserLessonProgressMapper.toJpa(progress)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
