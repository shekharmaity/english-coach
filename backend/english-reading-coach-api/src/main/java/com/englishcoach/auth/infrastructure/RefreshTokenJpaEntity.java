package com.englishcoach.auth.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokenJpaEntity extends PanacheEntityBase {
  @Id public UUID id;

  @Column(name = "user_id", nullable = false)
  public UUID userId;

  @Column(name = "token_hash", nullable = false, unique = true)
  public String tokenHash;

  @Column(name = "expires_at", nullable = false)
  public Instant expiresAt;

  @Column(name = "revoked_at")
  public Instant revokedAt;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt;
}
