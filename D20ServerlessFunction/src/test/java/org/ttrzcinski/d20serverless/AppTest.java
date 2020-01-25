package org.ttrzcinski.d20serverless;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.ttrzcinski.d20serverless.dictonaries.ContentTypesDictionary.JSON;

import org.junit.Test;
import org.ttrzcinski.d20serverless.rest.GatewayResponse;

/**
 * Tests covering lambda as an application.
 */
public class AppTest {

  @Test
  public void successfulResponse() {
    App app = new App();
    GatewayResponse result = (GatewayResponse) app.handleRequest(null, null);
    assertEquals(result.getStatusCode(), 200);
    assertEquals(
        result.getHeaders().get("Content-Type"), JSON.getContentType()
    );
    String content = result.getBody();
    assertNotNull(content);
    assertTrue(content.contains("\"message\""));
    assertTrue(content.contains("\"location\""));
  }
}
