package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AccountTest {
  // 実際にnewして使ってみるテスト
  /**
   * Rigorous Test :-)
   */
  @Test public void shouldAnswerWithTrue() {
    Account a = new Account("ミナト", 30000);
    assertEquals("ミナト", a.owner);
    assertEquals(30000, a.balance);
  }
}
