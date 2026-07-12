package com.englishcoach.statistics.infrastructure;

import com.englishcoach.statistics.domain.ReadingStats;
import com.englishcoach.statistics.domain.StatisticsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import java.math.BigInteger;
import java.util.UUID;

@ApplicationScoped
public class PanacheStatisticsRepository implements StatisticsRepository {
  private final EntityManager entityManager;

  public PanacheStatisticsRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public ReadingStats getReadingStats(UUID userId) {
    Long completedLessons =
        scalar(
            "select count(*) from user_lesson_progress where user_id = ?1 and status = 'COMPLETED'",
            userId);
    Long completedSessions =
        scalar(
            "select count(*) from reading_sessions where user_id = ?1 and status = 'COMPLETED'",
            userId);
    Long totalWords =
        scalar(
            "select coalesce(sum(words_read), 0) from reading_sessions where user_id = ?1", userId);

    return new ReadingStats(userId, completedLessons, completedSessions, totalWords);
  }

  private Long scalar(String sql, UUID userId) {
    Object value = entityManager.createNativeQuery(sql).setParameter(1, userId).getSingleResult();
    if (value instanceof BigInteger bigInteger) {
      return bigInteger.longValue();
    }
    if (value instanceof Number number) {
      return number.longValue();
    }
    return Long.parseLong(value.toString());
  }
}
