import java.io.*;
import java.nio.file.*;

public class Lesson9 {
  public static void main(String[] args) {
    try (FileWriter fw = new FileWriter("testfile.txt", true);) {
      // fileへの書き込み
      fw.write('A');
      fw.write("BCD");
      fw.flush();
    } catch (IOException e) {
      e.getMessage();
    }
    
    System.out.println("読み込んだデータを1文字ずつ表示します。");
    try (FileReader fr = new FileReader("testfile.txt");) {
      //fileの読み込み
      int i = fr.read(); // 1文字
      while (i != -1) {
        char c = (char) i;
        System.out.println(c);
        i = fr.read();
      }
      System.out.println("ファイルの末尾に到達しました。");
    } catch (IOException e) {
      e.getMessage();
    }

    // Path ファイルを指し示すクラス
    // testfile.txtのPathインスタンスを作成
    Path p1 = Paths.get("testfile.txt");
    Path p2 = Paths.get("test2file.txt"); // コピー先のファイルはコピー時に作成される
    try {
      // Filesクラスのcopyメソッド
      Files.copy(p1, p2);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  public void copyMethod(File f1, File f2) {
    try (
      FileInputStream fis= new FileInputStream(f1);
      FileOutputStream fos = new FileOutputStream(f2);
      ) {
      int data = fis.read();
      while (data != -1) {
        fos.write(data);
        data = fis.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
