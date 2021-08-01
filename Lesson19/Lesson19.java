package Lesson19;

import java.util.*;

class CountUpThread extends Thread {
  public void run() {
    for (int i = 0; i <= 50; i++) {
      System.out.println(i);
    }
  }
}

public class Lesson19 {
  public static void main(String[] args) throws InterruptedException {
    CountUpThread t1 = new CountUpThread();
    CountUpThread t2 = new CountUpThread();
    CountUpThread t3 = new CountUpThread();
    t3.start();
    t3.join();
    t2.start();
    t2.join();
    t1.start();
  }
}
