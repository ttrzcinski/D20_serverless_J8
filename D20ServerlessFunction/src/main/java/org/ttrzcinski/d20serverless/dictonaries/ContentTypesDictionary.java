package org.ttrzcinski.d20serverless.dictonaries;

/**
 * Usable formats of message in REST.
 */
public enum ContentTypesDictionary {
  JSON("application/json"),
  PLAIN("text/plain"),
  XML("application/xml"),
  HTML("text/html");

  private final String contentType;

  ContentTypesDictionary(String contentType) {
    this.contentType = contentType;
  }

  public String getContentType() {
    return this.contentType;
  }
}
