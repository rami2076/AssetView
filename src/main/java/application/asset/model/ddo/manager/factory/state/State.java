package application.asset.model.ddo.manager.factory.state;

import application.asset.model.entity.DBProperty;

public class State {

	//状態の判定
	//状態の取得
	//状態により振る舞いを決定
	//振る舞いの実施。

	private enum state{
		delete(1),
		create(2),
		reset(3),
		insert(4),
		update(5);
		private int id;
		state(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
	}



	int state;
	public Integer getState(){
		return null;
	}


	public  State(DBProperty operator,DBProperty target){
		//ROLEが存在しているか
		//"select rolname from pg_roles;";
		//DBが存在しているか？
		//ここで存在しているか確認する。
		//今回はしない。

		switch(target){
			case AssetAccesser:
				
			case DBAdministrater:
		}
	}

}
