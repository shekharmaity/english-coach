package com.englishcoach.lesson.infrastructure;

import com.englishcoach.lesson.domain.Lesson;
import com.englishcoach.lesson.domain.LessonRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheLessonRepository
    implements LessonRepository, PanacheRepositoryBase<LessonJpaEntity, UUID> {
  @Override
  public Optional<Lesson> getById(UUID id) {
    return findByIdOptional(id).map(LessonMapper::toDomain);
  }

  @Override
  public Optional<Lesson> getBySlug(String slug) {
    return find("slug", slug).firstResultOptional().map(LessonMapper::toDomain);
  }

  @Override
  public List<Lesson> listPublishedByCategory(UUID categoryId) {
    return list("categoryId = ?1 and published = true order by sortOrder, title", categoryId)
        .stream()
        .map(LessonMapper::toDomain)
        .toList();
  }

  @Override
  public Lesson save(Lesson lesson) {
    return LessonMapper.toDomain(getEntityManager().merge(LessonMapper.toJpa(lesson)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
