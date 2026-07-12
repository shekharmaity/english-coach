package com.englishcoach.auth.infrastructure;

import com.englishcoach.auth.domain.UserRole;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(nullable = false, unique = true)
  public String email;

  @Column(name = "password_hash", nullable = false)
  public String passwordHash;

  @Column(name = "display_name", nullable = false)
  public String displayName;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public UserRole role;

  @Column(name = "email_verified", nullable = false)
  public boolean emailVerified;

  @Column(name = "preferred_timezone", nullable = false)
  public String preferredTimezone;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt;
}
