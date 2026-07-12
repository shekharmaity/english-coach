package com.englishcoach.auth.infrastructure;

import com.englishcoach.auth.domain.RefreshToken;
import com.englishcoach.auth.domain.RefreshTokenRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheRefreshTokenRepository
    implements RefreshTokenRepository, PanacheRepositoryBase<RefreshTokenJpaEntity, UUID> {
  @Override
  public Optional<RefreshToken> getById(UUID id) {
    return findByIdOptional(id).map(RefreshTokenMapper::toDomain);
  }

  @Override
  public Optional<RefreshToken> getByTokenHash(String tokenHash) {
    return find("tokenHash", tokenHash).firstResultOptional().map(RefreshTokenMapper::toDomain);
  }

  @Override
  public RefreshToken save(RefreshToken refreshToken) {
    return RefreshTokenMapper.toDomain(
        getEntityManager().merge(RefreshTokenMapper.toJpa(refreshToken)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
