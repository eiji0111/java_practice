import java.util.*;

class Hero {
  private String name;
  public Hero(String name) { this.name = name; }
  public String getName() { return this.name; }
}

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

    Map<Integer, String> items = new HashMap<>();
    items.put(1, "りんご");
    items.put(2, "みかん");
    System.out.println(items.get(2));

    Hero hero1 = new Hero("斉藤");
    Hero hero2 = new Hero("鈴木");
    List<String> heroes = new ArrayList<>();
    heroes.add(hero1.getName());
    heroes.add(hero2.getName());

    for(String name : heroes) {
      System.out.println(name);
    }

    Map<String, Integer> attack_counts = new HashMap<>();
    attack_counts.put(hero1.getName(), 3);
    attack_counts.put(hero2.getName(), 7);

    for(String key : attack_counts.keySet()) {
      int value = attack_counts.get(key);
      System.out.println(key + "が倒した敵=" + value);
    }

    // List<Hero> heroes = new ArrayList<>();
    // 上記のように<インスタンスの型>を入れることもできる
  }
}
