package com.englishcoach.category.infrastructure;

import com.englishcoach.category.domain.Category;
import java.util.UUID;

final class CategoryMapper {
  private CategoryMapper() {}

  static Category toDomain(CategoryJpaEntity entity) {
    return new Category(
        entity.id,
        entity.slug,
        entity.title,
        entity.description,
        entity.sortOrder,
        entity.active,
        entity.createdAt,
        entity.updatedAt);
  }

  static CategoryJpaEntity toJpa(Category category) {
    CategoryJpaEntity entity = new CategoryJpaEntity();
    entity.id = category.id() == null ? UUID.randomUUID() : category.id();
    entity.slug = category.slug();
    entity.title = category.title();
    entity.description = category.description();
    entity.sortOrder = category.sortOrder();
    entity.active = category.active();
    entity.createdAt = category.createdAt();
    entity.updatedAt = category.updatedAt();
    return entity;
  }
}
