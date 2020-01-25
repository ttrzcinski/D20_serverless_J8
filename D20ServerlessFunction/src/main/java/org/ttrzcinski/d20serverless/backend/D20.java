package org.ttrzcinski.d20serverless.backend;

import java.util.Random;
import org.ttrzcinski.d20serverless.interfaces.IDice;

/**
 * Proper D20 dice.
 */
public class D20 implements IDice {

  /**
   * Kept randomize instance.
   */
  private Random random;

  /**
   * Last roll's score.
   */
  private int lastRoll = 1;

  /**
   * Roll the dice and return the score.
   *
   * @return roll's score
   */
  @Override
  public final int roll() {
    this.lastRoll = rollInRange(1, 20);
    return this.lastRoll;
  }

  /**
   * Roll from within range of given min and max value.
   *
   * @param min given min value
   * @param max given max value
   * @return score of roll from min and max value
   */
  public final int rollInRange(int min, int max) {
    // Swap values, if they are not ordered
    if (min >= max) {
      int tmp = max;
      max = min;
      min = tmp;
    }
    // Assure initialized randomize instance
    if (this.random == null) {
      this.random = new Random();
    }
    // Roll the dice
    return this.random.nextInt((max - min) + 1) + min;
  }

  /**
   * Returns last roll's score.
   *
   * @return last score
   */
  @Override
  public final int getLastRoll() {
    return this.lastRoll;
  }
}
