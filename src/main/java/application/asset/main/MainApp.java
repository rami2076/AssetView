package application.asset.main;

import java.io.IOException;

import application.asset.controller.CreateContoroller;
import application.asset.model.entity.AssetBind;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<AssetBind> assetBindObservableList;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("");

		initRootLayout();

		showCreateOverview();

	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			// /asset/src/main/java/application/asset/main/MainApp.java
		//	   /asset/src/main/resources/fxml/CreateOverview.fxml
			loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showCreateOverview() {
		try {
			// Load Asset overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/CreateOverview.fxml"));
			AnchorPane createOverview = (AnchorPane) loader.load();
			// Set asset overview/ into the center of root layout.
			createOverview.heightProperty();
			rootLayout.setCenter(createOverview);
			//Give the contoroller access to the main app
			CreateContoroller createContoroller = loader.getController();
			createContoroller.setMainApp(this);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public  Stage getPrimaryStage(){
		return primaryStage;
	}

public ObservableList<AssetBind> getAssetBindObservableList(){
	return assetBindObservableList;
}

	public static void main(String[] args) {

		launch(args);
	}
}
// 取引番号,取引原資産,オプションの種類,方向, 取引内容 ,購入,ペイアウト ,判定レート , 取引時間 , 終了時刻