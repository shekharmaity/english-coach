package com.englishcoach.lesson.dto;

import com.englishcoach.lesson.domain.LessonDifficulty;
import java.util.UUID;

public record LessonResponse(
    UUID id,
    UUID categoryId,
    String slug,
    String title,
    String description,
    LessonDifficulty difficulty,
    int estimatedSeconds,
    int defaultSpeedWpm,
    boolean published) {}
