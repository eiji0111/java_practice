package Lesson18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class MyLogger {

  private static MyLogger theInstance;
  private FileWriter filewriter;

  private MyLogger() {
    try {
      FileWriter fr = new FileWriter("Lesson18/dummylog.txt");
      this.filewriter = fr;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static MyLogger getInstance() {
    if (theInstance == null) {
      theInstance = new MyLogger();
    }
    return theInstance;
  }

  public void log(String text) {
    // 開いたファイルに書き込む処理
    try {
      this.filewriter.write(text);
      this.filewriter.flush();
    } catch (Exception e) {
      System.out.println("書き込みに失敗しました");
      System.out.println(e.getMessage());
    } 
  }
}
