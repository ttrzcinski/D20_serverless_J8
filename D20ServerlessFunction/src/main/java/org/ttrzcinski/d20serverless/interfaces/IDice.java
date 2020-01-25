package org.ttrzcinski.d20serverless.interfaces;

/**
 * Represents a simple dice - same-sided shape with randomized result.
 */
public interface IDice {

  /**
   * Rolls the dice to get next score.
   *
   * @return score
   */
  int roll();

  /**
   * Returns last known score.
   *
   * @return last score
   */
  int getLastRoll();
}
