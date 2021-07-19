import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // 1から100までの整数をカンマで連結した文字列sを生成
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 100; i ++) {
      sb.append(i);
      sb.append(",");
    }
    String s = sb.toString();
    System.out.println(s);

    // 文字列sをカンマで区切って文字配列aを作成
    String[] a = s.split("[,]");
    System.out.println(Arrays.toString(a));
  }
  String concatPath(String folder, String file) {
    if(!folder.endsWith("¥¥")) {
      folder += "¥¥";
    }
    return folder + file;
  }

  // すべての文字列
  // ".*"
  // 最初の文字A、2文字目は数字、3文字目は数字か無し
  // "A¥d{1,2}"
  // 最初の1文字はU、2~4文字は英大文字
  // "U[A-Z]{3}"
}