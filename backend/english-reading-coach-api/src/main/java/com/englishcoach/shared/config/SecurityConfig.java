package com.englishcoach.shared.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "english-coach.security")
public interface SecurityConfig {
  String jwtIssuer();

  String jwtSigningKey();
}
