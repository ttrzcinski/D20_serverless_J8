package org.ttrzcinski.d20serverless.rest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
public class GatewayResponse {

  private final String body;
  private final Map<String, String> headers;
  private final int statusCode;

  public GatewayResponse(final String body, final Map<String, String> headers, final int statusCode) {
    this.statusCode = statusCode;
    this.body = body;
    this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
  }

  public String getBody() {
    return this.body;
  }

  public Map<String, String> getHeaders() {
    return this.headers;
  }

  public int getStatusCode() {
    return this.statusCode;
  }
}
