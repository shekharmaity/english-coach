package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ReadingSession;
import com.englishcoach.progress.domain.ReadingSessionRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheReadingSessionRepository
    implements ReadingSessionRepository, PanacheRepositoryBase<ReadingSessionJpaEntity, UUID> {
  @Override
  public Optional<ReadingSession> getById(UUID id) {
    return findByIdOptional(id).map(ReadingSessionMapper::toDomain);
  }

  @Override
  public ReadingSession save(ReadingSession readingSession) {
    return ReadingSessionMapper.toDomain(
        getEntityManager().merge(ReadingSessionMapper.toJpa(readingSession)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
