import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.NameList;

public class Lesson3 {
  public static void main(String[] args) {
    // <>ジェネリクス
    // 配列よりも要素が柔軟なArrayListがよく使われている
    // ArrayListはインスタンス型でないと格納できない ArrayList<int>はできない
    ArrayList<String> names = new ArrayList<>();
    names.add("田中");
    names.add("森");
    names.add("小野寺");

    System.out.println(names);

    // setは上書き
    names.set(0, "吉岡");
    // addは挿入
    names.add("竹内");

    System.out.println(names);

    //for文
    for (int i = 0; i < names.size(); i ++) {
      System.out.println(names.get(i));
    }
    // 拡張for文
    for (String name : names) {
      System.out.println(name);
    }

    //イテレータの取得
    Iterator <String> it = names.iterator();
    while(it.hasNext()) {
      String name = it.next();
      System.out.println(name);
    }
  }
}
