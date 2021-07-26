package com.example;

public class Bank {
  String name; // 銀行名 必ず3文字以上が設定される

  public String getName() {
    return name;
  }
  public void setName(String name) {
    if (name.length() < 3) {
      throw new IllegalArgumentException("名前が不正です");
    }
    this.name = name;
  }
}
