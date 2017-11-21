package application.asset.model.ddo.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.asset.model.ddo.logic.IF.DDO_IF;
import application.asset.model.ddo.logic.base.DBMSConnector;

public class AddGrantForRole extends DBMSConnector implements DDO_IF {

	@Override
	public Boolean run() {

		//コネクションの確率
		connection();
		sql = "";
		try{
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {

			String cls = rs.getString("class");// classを取得

			String name = rs.getString("name");// nameを取得

			String club = rs.getString("club"); // clubを取得

			int point = rs.getInt("point"); // pointを取得

			String domain = rs.getString("domain");// domainを取得
			// 結果をコンソールに表示
			System.out.println(cls + " " + name + " " + club + " " + point + " " + domain);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null;
	}

	}
