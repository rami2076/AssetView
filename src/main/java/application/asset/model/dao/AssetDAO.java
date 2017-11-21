package application.asset.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssetDAO {

	public void select() throws SQLException {
		try {

			Class.forName("org.postgresql.Driver"); // ドライバクラスをロード
			Connection con = DriverManager.getConnection("DBMS", "username", "password");

			// ステートメントオブジェクトを生成
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM meibo";// SQL文を指定
			// クエリーを実行して結果セットを取得
			ResultSet rs = stmt.executeQuery(sql);
			// 検索された行数分ループ
			while (rs.next()) {

				String cls = rs.getString("class");// classを取得

				String name = rs.getString("name");// nameを取得

				String club = rs.getString("club"); // clubを取得

				int point = rs.getInt("point"); // pointを取得

				String domain = rs.getString("domain");// domainを取得
				// 結果をコンソールに表示
				System.out.println(cls + " " + name + " " + club + " " + point + " " + domain);
			}
			// データベースから切断
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean connect(){

		String url ="jdbc:postgresql://127.0.0.1:5432/postgres";
		String user="postgres";
		String password ="1853";

		String testUser = "postgres";
		String testpassword = "1853";

		//user = testUser;
		//password = testpassword;

		try{
			Class.forName("org.postgresql.Driver");//Driverクラスのロード
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("OK");
			return true;
		}catch(ClassNotFoundException e){
			e.getStackTrace();
			System.out.println("NG");
			return false;
		}catch(SQLException e){
			e.getStackTrace();
			System.out.println("NG");
			return false;
		}
	}




}
