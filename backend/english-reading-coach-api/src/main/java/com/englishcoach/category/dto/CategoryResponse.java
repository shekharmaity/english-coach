package com.englishcoach.category.dto;

import java.util.UUID;

public record CategoryResponse(
    UUID id, String slug, String title, String description, int sortOrder, boolean active) {}
