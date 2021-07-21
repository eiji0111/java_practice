import java.util.*;

interface Func1 {
  // xが奇数かどうか判定する
  // interface の public abstract は省略できる
  boolean isOdd(int x) ;
}
interface Func2 {
  // 性別から名前にどちらを付けるか決める
  String addNamePrefix(boolean male, String name);
}

public class Lesson6 {
  public static void main(String[] args) {
    Func1 odd = x -> x % 2 == 1;
    boolean result = odd.isOdd(10);
    System.out.println(result);

    Func2 new_name = (male, name) -> {
      if (male == true) {
        return "Mr." + name;
      } else {
        return "Ms." + name;
      }
    };
    // 別解 (male, name) -> ( male ? "Mr." : "Ms." ) + name;
    String theName = new_name.addNamePrefix(true, "mori");
    System.out.println(theName);
  }
}
