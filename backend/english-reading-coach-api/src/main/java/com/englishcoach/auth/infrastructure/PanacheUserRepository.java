package com.englishcoach.auth.infrastructure;

import com.englishcoach.auth.domain.User;
import com.englishcoach.auth.domain.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PanacheUserRepository
    implements UserRepository, PanacheRepositoryBase<UserJpaEntity, UUID> {
  @Override
  public Optional<User> getById(UUID id) {
    return findByIdOptional(id).map(UserMapper::toDomain);
  }

  @Override
  public Optional<User> getByEmail(String email) {
    return find("lower(email) = ?1", email.toLowerCase(Locale.ROOT))
        .firstResultOptional()
        .map(UserMapper::toDomain);
  }

  @Override
  public User save(User user) {
    return UserMapper.toDomain(getEntityManager().merge(UserMapper.toJpa(user)));
  }

  @Override
  public boolean remove(UUID id) {
    return deleteById(id);
  }
}
