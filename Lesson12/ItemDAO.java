package Lesson12;

import java.sql.*;
import java.util.*;

// データにアクセスするクラスをDAOと呼ぶ
public class ItemDAO {
  // findByMinimumPriceメソッドを作成
  public ArrayList<Item> findByMinimumPrice(int i) {
    // ドライバの読み込み
    try {
      Class.forName("org.h2.driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try (
      // テータベースに接続
      Connection con = DriverManager.getConnection("jdbc:h2:~/rpgdb");
      // SQLの雛形(検索系)を準備
      PreparedStatement ps = con.prepareStatement
      ( "SELECT * FROM ITEMS WHERE PRICE > ?" );)
    {
      // SQLに値を指定
      ps.setInt(1, i);
      // SQLを送信 返り表をResultSetで受ける
      ResultSet rs = ps.executeQuery();
      // 結果の処理
      ArrayList<Item> items = new ArrayList<>();
      while (rs.next()) {
        // 取得した列をitemsに格納
        Item item = new Item();
        item.setName(rs.getString("NAME"));
        item.setPrice(rs.getInt("PRICE"));
        item.setWeight(rs.getInt("WEIGHT"));
        items.add(item);
      }
      return items;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
