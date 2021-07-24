import java.io.*;
import java.net.*;

public class Lesson11 {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://dokojava.jp/favicon.ico");
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream("dj.ico");
    int i = is.read();
    while (i != -1) {
      os.write((byte) i);
      i = is.read();
    }
    is.close();
    os.flush();
    os.close();

    // 例題の仮想サイトのソケットを作成
    // コンパイルエラー防止のためコメントアウトで作成
    // Socket sock = new Socket("smtp.example.com", 60025);
    // OutputStream outs = new sock.getOuputStream();
    // outs.write("HELO example.com¥n" .getBytes());
    // outs.write("MAIL FROM: asaka@example.com¥n" .getBytes());
    // ~ 以下略 ~
    // outs.flush();
    // sock.close();
  }
}