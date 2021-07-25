package Lesson12;
import java.sql.*;

public class Jdbc {
  public static void main(String[] args) {
    
    try {
      // jarファイル内のドライバの読み込み
      Class.forName("org.h2.driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    // Connection con = null;
    try (
      Connection con = DriverManager.getConnection("jdbc:h2:~/rpgdb");
      PreparedStatement pstmt = con.prepareStatement
        ("DELETE FROM MONSTERS WHERE HP <= ? OR NAME = ?");)
    {
      // データベースへの接続
      // con = DriverManager.getConnection("jdbc:h2:~/rpgdb");
      // SQL送信処理(検索系・更新系で要領異なる)
      // 難易度 更新系 < 検索系
      // Step1 SQLの雛形を準備
      // PreparedStatement pstmt = con.prepareStatement
      //   ("DELETE FROM MONSTERS WHERE HP <= ? OR NAME = ?");
      // Step2 SQLに値をセット(何番目の?に何を入れるか1から始まることに注意)
      pstmt.setInt(1, 10); // 1番目に10
      pstmt.setString(2, "ゾンビ"); // 2番目にゾンビ
      int r = pstmt.executeUpdate(); // 更新結果数がintで返る
      // Step3 処理結果を判定
      if (r != 0) {
        System.out.println( r + "件のモンスターを削除しました");
      } else {
        System.out.println("該当するモンスターが見つかりませんでした");
      }
      // 再度値をセット
      pstmt.setInt(1, 20);
      pstmt.setString(2, "スライム");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getString("NAME"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //  finally {
    //   // データベースの切断
    //   if (con != null) {
    //     try {
    //       con.close();
    //     } catch (SQLException e) {
    //       e.printStackTrace();
    //     }
    //   }
  }
}
