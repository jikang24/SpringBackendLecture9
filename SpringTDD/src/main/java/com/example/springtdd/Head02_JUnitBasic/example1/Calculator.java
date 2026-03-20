package com.example.springtdd.Head02_JUnitBasic.example1;

public class Calculator {

  public int add(int a, int b) {
     return a + b;
   }

   public int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("b cannot be zero");
    }
     return a / b;
   }

}
