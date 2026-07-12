package com.englishcoach.shared.error;

import com.englishcoach.shared.logging.TraceIdFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;
import org.jboss.logging.Logger;

@Provider
public class UnhandledExceptionMapper implements ExceptionMapper<Throwable> {
  private static final Logger LOG = Logger.getLogger(UnhandledExceptionMapper.class);

  @Override
  public Response toResponse(Throwable exception) {
    LOG.errorf(exception, "Unhandled API exception traceId=%s", TraceIdFilter.currentTraceId());

    ErrorResponse body =
        new ErrorResponse(
            "INTERNAL_SERVER_ERROR",
            "An unexpected server error occurred.",
            Map.of(),
            TraceIdFilter.currentTraceId());

    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(body).build();
  }
}
