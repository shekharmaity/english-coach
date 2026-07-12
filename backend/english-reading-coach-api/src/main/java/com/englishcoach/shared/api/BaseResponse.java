package com.englishcoach.shared.api;

import java.time.Instant;

public record BaseResponse<T>(boolean success, T data, String traceId, Instant timestamp) {
  public static <T> BaseResponse<T> success(T data, String traceId) {
    return new BaseResponse<>(true, data, traceId, Instant.now());
  }
}
