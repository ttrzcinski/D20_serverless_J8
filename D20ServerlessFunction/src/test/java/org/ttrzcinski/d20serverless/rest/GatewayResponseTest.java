package org.ttrzcinski.d20serverless.rest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Covers POJO accessors functionality.
 */
public class GatewayResponseTest {

  @Test
  public void constructor_returnsSomething() {
    // Arrange
    String testBody = "";
    int testStatusCode = 200;
    Map testHeaders = new HashMap<String, String>();

    // Act
    GatewayResponse result = new GatewayResponse(testBody, testHeaders, testStatusCode);

    // Assert
    assertNotNull(result);
  }

  @Test
  public void getBody_returnsSomething() {
    // Arrange
    String testBody = "some";
    int testStatusCode = 200;
    Map testHeaders = new HashMap<String, String>();

    // Act
    GatewayResponse gatewayResponse = new GatewayResponse(testBody, testHeaders, testStatusCode);
    String actual = gatewayResponse.getBody();

    // Assert
    assertEquals(testBody, actual);
  }

  @Test
  public void getStatusCode_returnsSomething() {
    // Arrange
    String testBody = "some";
    int testStatusCode = 200;
    Map testHeaders = new HashMap<String, String>();

    // Act
    GatewayResponse gatewayResponse = new GatewayResponse(testBody, testHeaders, testStatusCode);
    int actual = gatewayResponse.getStatusCode();

    // Assert
    assertEquals(testStatusCode, actual);
  }

  @Test
  public void getHeaders_returnsSomething() {
    // Arrange
    String testBody = "some";
    int testStatusCode = 200;
    Map testHeaders = new HashMap<String, String>();
    testHeaders.put("test1", "value1");
    testHeaders.put("test2", "value2");
    testHeaders.put("test3", "value3");

    // Act
    GatewayResponse gatewayResponse = new GatewayResponse(testBody, testHeaders, testStatusCode);
    Map actual = gatewayResponse.getHeaders();

    // Assert
    assertEquals(testHeaders, actual);
  }
}
