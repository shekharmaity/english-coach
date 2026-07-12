package com.englishcoach.lesson.dto;

import java.util.UUID;

public record SentenceResponse(
    UUID id, UUID lessonId, int position, String content, int wordCount) {}
