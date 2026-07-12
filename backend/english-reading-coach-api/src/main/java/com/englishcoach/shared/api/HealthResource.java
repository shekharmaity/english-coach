package com.englishcoach.shared.api;

import com.englishcoach.shared.config.SecurityConfig;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Instant;

@Path("/api/v1/health")
@Produces(MediaType.APPLICATION_JSON)
public class HealthResource {
  private final SecurityConfig securityConfig;

  public HealthResource(SecurityConfig securityConfig) {
    this.securityConfig = securityConfig;
  }

  @GET
  public HealthResponse health() {
    return new HealthResponse(
        "ok", "english-reading-coach-api", securityConfig.jwtIssuer(), Instant.now());
  }
}
