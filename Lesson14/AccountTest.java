package Lesson14;

public class AccountTest {
  public static void main(String[] args) {
    testInstantiate(); // 1つ目のテスト
    // testTransfer(); // 2つ目のテスト
  }
  // 実際にAccountをnewして使ってみるテスト
  private static void testInstantiate() {
    System.out.println("テストを開始します");
    Account a = new Account("ミナト", 30000);
    if (!"ミナト".equals(a.owner)) {
      System.out.println("失敗！　名義人がおかしい！");
    }
    if (30000 != a.balance) {
      System.out.println("失敗！　残高がおかしい");
    }
    System.out.println("テストを終了します");
  }
}
