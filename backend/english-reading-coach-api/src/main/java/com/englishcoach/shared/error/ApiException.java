package com.englishcoach.shared.error;

import jakarta.ws.rs.core.Response.Status;
import java.util.Map;

public class ApiException extends RuntimeException {
  private final String code;
  private final Status status;
  private final Map<String, Object> details;

  public ApiException(String code, String message, Status status) {
    this(code, message, status, Map.of());
  }

  public ApiException(String code, String message, Status status, Map<String, Object> details) {
    super(message);
    this.code = code;
    this.status = status;
    this.details = Map.copyOf(details);
  }

  public String code() {
    return code;
  }

  public Status status() {
    return status;
  }

  public Map<String, Object> details() {
    return details;
  }
}
