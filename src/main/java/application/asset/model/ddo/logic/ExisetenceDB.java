package application.asset.model.ddo.logic;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import application.asset.model.ddo.logic.IF.DDO_IF;
import application.asset.model.ddo.logic.base.DBMSConnector;

public class ExisetenceDB extends DBMSConnector implements DDO_IF  {

	@Override
	public Boolean run() {
		sql ="exists(select rolname from pg_roles);";
	 //stmt.execute(sql);
	 try {
		DatabaseMetaData a =con.getMetaData();
		//
		//sResultSet rs = a.
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}


		return true;
	}
}
