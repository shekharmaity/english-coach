package com.englishcoach.progress.infrastructure;

import com.englishcoach.progress.domain.ReadingSessionSentenceEvent;
import com.englishcoach.progress.domain.ReadingSessionSentenceEventRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheReadingSessionSentenceEventRepository
    implements ReadingSessionSentenceEventRepository,
        PanacheRepositoryBase<ReadingSessionSentenceEventJpaEntity, UUID> {
  @Override
  public Optional<ReadingSessionSentenceEvent> getById(UUID id) {
    return findByIdOptional(id).map(ReadingSessionSentenceEventMapper::toDomain);
  }

  @Override
  public List<ReadingSessionSentenceEvent> listByReadingSession(UUID readingSessionId) {
    return list("readingSessionId = ?1 order by sentencePosition", readingSessionId).stream()
        .map(ReadingSessionSentenceEventMapper::toDomain)
        .toList();
  }

  @Override
  public ReadingSessionSentenceEvent save(ReadingSessionSentenceEvent event) {
    return ReadingSessionSentenceEventMapper.toDomain(
        getEntityManager().merge(ReadingSessionSentenceEventMapper.toJpa(event)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
