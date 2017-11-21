package application.asset.model.ddo.logic.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import application.asset.model.entity.DBProperty;

public class DBMSConnector {

	protected Connection con;
	protected Statement stmt;
	protected String sql;

	protected void connection() {
		DBProperty dbProperty = DBProperty.DBAdministrater;

		try {
			//ドライバのロード
			Class.forName(dbProperty.getDriverClassName());

			//データベースと接続
			this.con = DriverManager.getConnection
					(
						dbProperty.getURL(),
						dbProperty.getUser(),
						dbProperty.getPassword()
					);

			// ステートメントオブジェクトを生成
			this.stmt = con.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("NG");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("NG");
			e.printStackTrace();
		}

	}
}
