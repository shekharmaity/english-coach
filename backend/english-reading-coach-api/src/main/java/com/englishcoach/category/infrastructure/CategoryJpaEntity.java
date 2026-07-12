package com.englishcoach.category.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(nullable = false, unique = true)
  public String slug;

  @Column(nullable = false)
  public String title;

  @Column(nullable = false)
  public String description;

  @Column(name = "sort_order", nullable = false)
  public int sortOrder;

  @Column(nullable = false)
  public boolean active;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
