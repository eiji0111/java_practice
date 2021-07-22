import java.io.*;

public class Lesson9 {
  public static void main(String[] args) {
    FileWriter fw = null;
    try {
      // fileへの書き込み
      fw = new FileWriter("testfile.txt", true);
      fw.write('A');
      fw.write("BCD");
      fw.flush();
    } catch (IOException e) {
      e.getMessage();
    } finally {
      if (fw != null) {
        try {
          fw.close();
        } catch (IOException e) {}
      }
    }
    //fileの読み込み
    FileReader fr = null;
    System.out.println("読み込んだデータを1文字ずつ表示します。");
    try {
      fr = new FileReader("testfile.txt");
      int i = fr.read(); // 1文字
      while (i != -1) {
        char c = (char) i;
        System.out.println(c);
        i = fr.read();
      }
      System.out.println("ファイルの末尾に到達しました。");
    } catch (IOException e) {
      e.getMessage();
    } finally {
      try {
        if (fr != null) {
          fr.close();
        }
      } catch (IOException e) {}
    }
  }
}
