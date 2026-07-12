package com.englishcoach.shared.logging;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import org.jboss.logging.MDC;

@Provider
public class TraceIdFilter implements ContainerRequestFilter, ContainerResponseFilter {
  public static final String TRACE_ID_HEADER = "X-Trace-Id";
  private static final String MDC_KEY = "traceId";

  public static String currentTraceId() {
    Object traceId = MDC.get(MDC_KEY);
    return traceId == null ? "unknown" : traceId.toString();
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String traceId =
        Optional.ofNullable(requestContext.getHeaderString(TRACE_ID_HEADER))
            .filter(value -> !value.isBlank())
            .orElseGet(() -> UUID.randomUUID().toString());
    MDC.put(MDC_KEY, traceId);
  }

  @Override
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {
    responseContext.getHeaders().putSingle(TRACE_ID_HEADER, currentTraceId());
    MDC.remove(MDC_KEY);
  }
}
