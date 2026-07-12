package com.englishcoach.auth.domain;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
  Optional<User> getById(UUID id);

  Optional<User> getByEmail(String email);

  User save(User user);

  boolean remove(UUID id);
}
