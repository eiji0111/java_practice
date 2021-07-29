package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class MovieTest {
  @Test public void shouldAnswerWithTrue() {
    Movie m = new Movie("もののけ姫");
  }

  @Test public void getterTest() {
    LocalDate today = LocalDate.now();
    Movie m = new Movie("もののけ姫", today);
    assertEquals("もののけ姫", m.getTitle());
    assertEquals("2021-07-29", m.getDate());
  }

  @Test public void setterTest() {
    LocalDate today = LocalDate.now();
    Movie m = new Movie();
    m.setDate(today);
    m.setTitle("もののけ姫");
    assertEquals("もののけ姫", m.getTitle());
    assertEquals(today, m.getDate());
  }

  @Test (expected = NullPointerException.class)
  public void notSetNull() {
    Movie m = new Movie();
    m.setDate(null);
    m.setTitle(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void notSetFeature() {
    Movie m = new Movie();
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    m.setDate(tomorrow);
  }
}
