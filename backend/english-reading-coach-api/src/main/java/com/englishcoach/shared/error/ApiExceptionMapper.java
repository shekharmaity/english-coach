package com.englishcoach.shared.error;

import com.englishcoach.shared.logging.TraceIdFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {
  @Override
  public Response toResponse(ApiException exception) {
    ErrorResponse body =
        new ErrorResponse(
            exception.code(),
            exception.getMessage(),
            exception.details(),
            TraceIdFilter.currentTraceId());

    return Response.status(exception.status()).entity(body).build();
  }
}
