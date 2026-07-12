package com.englishcoach.category.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
  Optional<Category> getById(UUID id);

  Optional<Category> getBySlug(String slug);

  List<Category> listActive();

  Category save(Category category);

  boolean remove(UUID id);
}
