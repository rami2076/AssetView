package application.asset.model.ddo.manager;

public class Cliant {



	//状態を判定。
	//状態により、生成パターンを決定
	//決定された生成パターンを実行。



	//roleが使いするroleがあり。
	//作成するデータベースがあり。
	//スキーマあり
	//テーブルあり
//上記の二つの場合呼ばれる。
	public  Boolean DBreset(){
		//データベースの削除
		//スキーマの削除
		//roleの削除
		//roleの作成
		//データベースの作成
		//権限の付与
		//テーブルの作成
		return true;
	}


	//作成するデータベースが無い場合
	//作成するroleが無い場合
	public Boolean DBCreate(){
		//roleの作成 Administrater
		//データベースの作成 Administrater
		//スキーマの作成 Administrater
		//テーブルの作成 asset_user
		//テーブルの作成 asset_user
		return true;
	}

	//作成するデータベースがある場合
	//作成するroleが無い場合
	public Boolean DBCreateNonRole(){
		//データベースの削除
		//roleの作成
		//データベースの作成
		//権限の付与
		//テーブルの作成
		return true;
	}

	//作成するデータベースがない場合
	//作成するroleがある場合
	public Boolean DBCreateNonDB(){
		//Roleの削除
		//Roleの作成
		//データベースの作成
		//テーブルの権限付与
		//テーブルの作成

		return true;
	}



}
