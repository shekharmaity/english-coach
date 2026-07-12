package com.englishcoach.statistics.domain;

import java.util.UUID;

public interface StatisticsRepository {
  ReadingStats getReadingStats(UUID userId);
}
