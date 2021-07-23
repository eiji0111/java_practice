import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Lesson9Practice {
  public static void main(String[] args) {
    String file1 = args[0]; // JVM起動パラメータを取得
    String file2 = args[1]; // JVM起動パラメータを取得
    BufferedInputStream bis = null; // 最後にファイルcloseの判定で使用するため
    GZIPOutputStream gout = null; // 最後にファイルcloseの判定で使用するため

    try {
      FileInputStream fis = new FileInputStream(file1);
      // input バッファリング
      bis = new BufferedInputStream(fis);
      FileOutputStream fos = new FileOutputStream(file2);
      // output バッファリング
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      // 圧縮インスタンス作成
      gout = new GZIPOutputStream(bos);

      int data = bis.read();
      while (data != -1) {
        gout.write(data);
        data = bis.read();
      }
      gout.flush();
      gout.close();
      bis.close();
    } catch (IOException e) {
      e.printStackTrace();
      try {
        if (bis != null) {
          bis.close();
        }
        if (gout != null) {
          gout.close();
        }
      } catch (Exception ee) {
      }
    }
  }
}
