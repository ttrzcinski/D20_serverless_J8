package org.ttrzcinski.d20serverless;

import static org.ttrzcinski.d20serverless.dictonaries.ContentTypesDictionary.JSON;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.ttrzcinski.d20serverless.backend.D20;
import org.ttrzcinski.d20serverless.rest.GatewayResponse;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Object, Object> {

  /**
   * Kept instance of D20 dice.
   */
  private D20 d20;

  /**
   * Keeps value of the lowest value obtainable with dice.
   */
  private final static int lowestSide = 1;

  /**
   * Keeps value of the highest value obtainable with dice.
   */
  private final static int newestSide = 20;

  /**
   * Handles passed request and serves as main-entry method.
   *
   * @param input passed input
   * @param context pointed context
   * @return HTTP response formed as JSON
   */
  public final Object handleRequest(final Object input, final Context context) {

    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", JSON.getContentType());
    headers.put("X-Custom-Header", JSON.getContentType());

    assureD20();
    int score = d20.roll();
    String result = this.commentARoll(score);

    try {
      final String pageContents = this.getPageContents("https://checkip.amazonaws.com");
      String output = String.format("{ \"message\": \"%s\", \"location\": \"%s\" }", result, pageContents);
      return new GatewayResponse(output, headers, 200);
    } catch (IOException e) {
      return new GatewayResponse("{}", headers, 500);
    }
  }

  private String getPageContents(String address) throws IOException {
    URL url = new URL(address);
    try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
      return br.lines().collect(Collectors.joining(System.lineSeparator()));
    }
  }

  /**
   * Initialize D20 dice, if it was not.
   */
  private void assureD20() {
    if (this.d20 == null) {
      this.d20 = new D20();
    }
  }

  /**
   * Provides comment for passed D20 roll.
   *
   * @param score passed roll's score
   * @return commented roll's score
   */
  private String commentARoll(int score) {
    String result;
    switch (score) {
      case App.lowestSide:
        result = String.format("Critical failure. Rolled %d.", lowestSide);
        break;
      case App.newestSide:
        result = String.format("Critical success. Rolled %d.", newestSide);
        break;
      default:
        result = String.format("Rolled %d", score);
        break;
    }
    return result;
  }
}
