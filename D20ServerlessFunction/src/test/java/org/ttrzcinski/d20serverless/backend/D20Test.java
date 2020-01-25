package org.ttrzcinski.d20serverless.backend;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ttrzcinski.d20serverless.backend.D20;

/**
 * Covers dice usage-related functionality.
 */
public class D20Test {

  /**
   * Kept instance of D20 dice.
   */
  private D20 dice;

  @Before
  public void setUp() {
    this.dice = new D20();
    Objects.requireNonNull(this.dice);
  }

  @After
  public void tearDown() {
    this.dice = null;
  }

  @Test
  public void roll() {
    // Arrange
    int expectedMin = 1;
    int expectedMax = 20;

    // Act
    int result = dice.roll();

    // Assert
    assertTrue(expectedMin <= result && result <= expectedMax);
  }

  @Test
  public void getLastRoll() {
    // Arrange
    int expectedMin = 1;
    int expectedMax = 20;

    // Act
    int result = dice.getLastRoll();

    // Assert
    assertTrue(expectedMin <= result && result <= expectedMax);
  }

  @Test
  public void rollInRange() {
    // Arrange
    int expectedMin = 1;
    int expectedMax = 6;

    // Act
    int result = dice.rollInRange(expectedMin, expectedMax);

    // Assert
    assertTrue(expectedMin <= result && result <= expectedMax);
  }

  @Test
  public void rollInRange_wrongOrder() {
    // Arrange
    int expectedMin = 6;
    int expectedMax = 1;

    // Act
    int result = dice.rollInRange(expectedMax, expectedMin);

    // Assert
    assertTrue(Math.min(expectedMin, expectedMax) <= result);
    assertTrue(result <= Math.max(expectedMin, expectedMax));
  }
}
