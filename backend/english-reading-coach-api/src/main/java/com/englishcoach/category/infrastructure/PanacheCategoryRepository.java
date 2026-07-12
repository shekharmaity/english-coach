package com.englishcoach.category.infrastructure;

import com.englishcoach.category.domain.Category;
import com.englishcoach.category.domain.CategoryRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheCategoryRepository
    implements CategoryRepository, PanacheRepositoryBase<CategoryJpaEntity, UUID> {
  @Override
  public Optional<Category> getById(UUID id) {
    return findByIdOptional(id).map(CategoryMapper::toDomain);
  }

  @Override
  public Optional<Category> getBySlug(String slug) {
    return find("slug", slug).firstResultOptional().map(CategoryMapper::toDomain);
  }

  @Override
  public List<Category> listActive() {
    return list("active = true order by sortOrder, title").stream()
        .map(CategoryMapper::toDomain)
        .toList();
  }

  @Override
  public Category save(Category category) {
    return CategoryMapper.toDomain(getEntityManager().merge(CategoryMapper.toJpa(category)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
