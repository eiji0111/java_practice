package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * unit test for Bank.java
 */
public class BankTest {
  @Test public void setNameTrue() {
    // 正常系 3文字を設定できる
    Bank b = new Bank();
    b.setName("三重銀");
  }
  @Test public void setNameNull() {
    // 異常系 nullを設定する
    try {
      Bank b2 = new Bank();
      b2.setName(null);
    } catch (NullPointerException e) {
      return;
    }
    fail();
  }
  @Test public void setNameTwoLength() {
    // 異常系 2文字を設定する
    try {
      Bank b3 = new Bank();
      b3.setName("三重");
    } catch (IllegalArgumentException e) {
      assertEquals("名前が不正です", e.getMessage());
    }
  }
  // あらかじめ例外を指定して作成することもできる
  // @Test (expected = IllegalArgumentException.class)
  // public void setNameTwoLength() {
  //   Bank b3 = new Bank();
  //   b3.setName("三重");
  // }
}
