/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void testAddPositive() {
    System.out.println("testAdd");
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }
  
  // TODO: add divide and isEven tests
}