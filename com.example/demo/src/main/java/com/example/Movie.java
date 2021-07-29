package com.example;

import java.time.LocalDate;

public class Movie {
  private String title;
  private LocalDate date;

  public Movie () {
  }
  public Movie (String title) {
    if (title == null) {
      throw new NullPointerException("nullは入力できません");
    }
    this.title = title;
  }
  public Movie (String title, LocalDate date) {
    if (title == null || date == null) {
      throw new NullPointerException("nullは入力できません");
    }
    this.title = title;
    this.date = date;
  }

  public String getTitle() {
    return title;
  }
  public LocalDate getDate() {
    return date;
  }
  public void setTitle(String title) {
    if (title == null) {
      throw new NullPointerException("nullは入力できません");
    }
    this.title = title;
  }
  public void setDate(LocalDate date) {
    int diff = date.compareTo(LocalDate.now());
    if (date == null) {
      throw new NullPointerException("nullは入力できません");
    }
    if(diff > 0) {
      throw new IllegalArgumentException("未来の日付は指定できません");
    }
    this.date = date;
  }
}
