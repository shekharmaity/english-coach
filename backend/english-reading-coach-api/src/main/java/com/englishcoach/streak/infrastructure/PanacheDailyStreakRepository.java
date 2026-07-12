package com.englishcoach.streak.infrastructure;

import com.englishcoach.streak.domain.DailyStreak;
import com.englishcoach.streak.domain.DailyStreakRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheDailyStreakRepository
    implements DailyStreakRepository, PanacheRepositoryBase<DailyStreakJpaEntity, UUID> {
  @Override
  public Optional<DailyStreak> getById(UUID id) {
    return findByIdOptional(id).map(DailyStreakMapper::toDomain);
  }

  @Override
  public Optional<DailyStreak> getByUserAndDate(UUID userId, LocalDate streakDate) {
    return find("userId = ?1 and streakDate = ?2", userId, streakDate)
        .firstResultOptional()
        .map(DailyStreakMapper::toDomain);
  }

  @Override
  public DailyStreak save(DailyStreak dailyStreak) {
    return DailyStreakMapper.toDomain(
        getEntityManager().merge(DailyStreakMapper.toJpa(dailyStreak)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
