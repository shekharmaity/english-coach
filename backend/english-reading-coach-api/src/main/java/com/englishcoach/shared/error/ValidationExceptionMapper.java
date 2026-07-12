package com.englishcoach.shared.error;

import com.englishcoach.shared.logging.TraceIdFilter;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
  @Override
  public Response toResponse(ConstraintViolationException exception) {
    List<Map<String, String>> violations =
        exception.getConstraintViolations().stream()
            .sorted(Comparator.comparing(violation -> violation.getPropertyPath().toString()))
            .map(this::toViolation)
            .toList();

    ErrorResponse body =
        new ErrorResponse(
            "VALIDATION_ERROR",
            "Request validation failed.",
            Map.of("violations", violations),
            TraceIdFilter.currentTraceId());

    return Response.status(Response.Status.BAD_REQUEST).entity(body).build();
  }

  private Map<String, String> toViolation(ConstraintViolation<?> violation) {
    return Map.of(
        "field", violation.getPropertyPath().toString(),
        "message", violation.getMessage());
  }
}
