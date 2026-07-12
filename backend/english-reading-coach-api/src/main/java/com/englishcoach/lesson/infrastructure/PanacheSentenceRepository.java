package com.englishcoach.lesson.infrastructure;

import com.englishcoach.lesson.domain.Sentence;
import com.englishcoach.lesson.domain.SentenceRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheSentenceRepository
    implements SentenceRepository, PanacheRepositoryBase<SentenceJpaEntity, UUID> {
  @Override
  public Optional<Sentence> getById(UUID id) {
    return findByIdOptional(id).map(SentenceMapper::toDomain);
  }

  @Override
  public List<Sentence> listByLesson(UUID lessonId) {
    return list("lessonId = ?1 order by position", lessonId).stream()
        .map(SentenceMapper::toDomain)
        .toList();
  }

  @Override
  public Sentence save(Sentence sentence) {
    return SentenceMapper.toDomain(getEntityManager().merge(SentenceMapper.toJpa(sentence)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
