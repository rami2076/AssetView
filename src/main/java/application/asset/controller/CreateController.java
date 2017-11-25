package application.asset.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import application.asset.main.MainApp;
import application.asset.model.entity.Asset;
import application.asset.model.entity.AssetBind;
import application.asset.model.entity.converter.ConvertBean;
import application.asset.model.logic.paser.Paser;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CreateController {

	@FXML
	private TableView<AssetBind> assetTable;
	@FXML
	private TableColumn<AssetBind, String> numberingColumn;
	@FXML
	private TableColumn<AssetBind, String> tradingNumberColumn;;
	@FXML
	private TableColumn<AssetBind, String> tradeAssetColumn;
	@FXML
	private TableColumn<AssetBind, String> optionColumn;
	@FXML
	private TableColumn<AssetBind, String> directionColumn;
	@FXML
	private TableColumn<AssetBind, String> tradeContentColumn;
	@FXML
	private TableColumn<AssetBind, String> tradeStaticsColumn;
	@FXML
	private TableColumn<AssetBind, String> purchaseColumn;
	@FXML
	private TableColumn<AssetBind, String> payoutColumn;
	@FXML
	private TableColumn<AssetBind, String> judgmentRateColumn;
	@FXML
	private TableColumn<AssetBind, String> tradeStartTimeColumn;
	@FXML
	private TableColumn<AssetBind, String> tradeEndTimeColumn;

	@FXML
	private Button fileSelectionButton;
	@FXML
	private TextField pathDisplayTextField;
	@FXML
	private Button dataDisplayButton;
	@FXML
	private Button dbStoringButton;
	@FXML
	private TextArea logDisplayTextArea;
	@FXML
	private Label fileNameLabel;
	@FXML
	private Label fileCountLabel;

	@FXML
	private TextField aaaatetFild;
	// reference to Main
	private MainApp mainApp;

	public CreateController() {

	}

	@FXML
	public void initialize() {
		//test_test_test
		ValidationSupport support = new ValidationSupport();
		Predicate<String> textPredicate = s -> ("OK").equals(s);
		support.registerValidator(aaaatetFild, false,
				Validator.createPredicateValidator(textPredicate, "Text is required", Severity.WARNING));
		// refer
		// https://qiita.com/monolith52/items/5a11ef104b0160229734




		// TODO FIX:: Variable name declaration.
		numberingColumn.setCellValueFactory(cellData -> cellData.getValue().iterateProperty());
		//TODO FIX:: Variavle name declaration
		tradeAssetColumn.setCellValueFactory(cellData -> cellData.getValue().underlyingProperty());
		tradingNumberColumn.setCellValueFactory(cellData -> cellData.getValue().tradingNumberProperty());
		optionColumn.setCellValueFactory(cellData -> cellData.getValue().optionProperty());
		directionColumn.setCellValueFactory(cellData -> cellData.getValue().directionProperty());
		// TODO FIX:: Variable name declaration.
		tradeContentColumn.setCellValueFactory(cellData -> cellData.getValue().tradeRateProperty());
		tradeStaticsColumn.setCellValueFactory(cellData -> cellData.getValue().tradeStaticsProperty());
		purchaseColumn.setCellValueFactory(cellData -> cellData.getValue().purchaseProperty());
		payoutColumn.setCellValueFactory(cellData -> cellData.getValue().payoutProperty());
		// TODO FIX Variable name declaration.
		judgmentRateColumn.setCellValueFactory(cellData -> cellData.getValue().decisionRateProperty());
		tradeStartTimeColumn.setCellValueFactory(cellData -> cellData.getValue().tradeStartTimeProperty());
		tradeEndTimeColumn.setCellValueFactory(cellData -> cellData.getValue().tradeEndTimeProperty());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// テーブルデータの初期化不要であると判断
		// http://code.makery.ch/library/javafx-8-tutorial/part2/
		// assetTable.setItems();
	}

	@FXML
	public void hadleCSVFileChooser(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("CSVファイルの選択");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("csv????", "*.csv"));
		Node node = (Node) event.getSource();
		File selectedFile = fileChooser.showOpenDialog(node.getScene().getWindow());
		if (selectedFile == null) {
			logDisplayTextArea.appendText("ファイル選択がキャンセルされました。00001\n");
		} else {
			pathDisplayTextField.setText(selectedFile.getName());
			pathDisplayTextField.setText(selectedFile.getPath());
			logDisplayTextArea.appendText("ファイルの選択が完了しました。\n");
		}

		// fileChooser.setInitialDirectory(ApplicationContext.getTracedFile());

		// String path = ApplicationContext.getCurrentTexb().path;
		// if (path != null) {
		// String name = new File(path).getName().replaceAll("\\.texb.*",
		// ".png");
		// fileChooser.setInitialFileName(name);
		// }
		// File file =
		// fileChooser.showSaveDialog(ApplicationContext.getStage());
		// if (file != null) {
		// System.out.println(file.getAbsolutePath());
		// BufferedImage img = (BufferedImage) ApplicationContext
		// .getCurrentTexb().awtImg;
		// try {
		// ImageIO.write(img, "png", file);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

	}

	@FXML
	public void handleCSVDataDisplay(ActionEvent event) {
		if (pathDisplayTextField.getText().equals("")) {
			logDisplayTextArea.appendText("CSVが設定されていない。");
		} else {
			File file = new File(pathDisplayTextField.getText());
			Paser paser = new Paser();
			ConvertBean convert = new ConvertBean();
			List<Asset> asset = new ArrayList<>();
			List<AssetBind> assetBind = new ArrayList<>();
			asset=paser.supercsvannotationToBean(file);

			System.out.println(asset.get(0).getDirection());
			ObservableList<AssetBind> list  = convert.toAssetBindList(asset);




			//ObservableList<AssetBind> list = (ObservableList<AssetBind>) convert.toAssetBindList(paser.opencsvToBean(file));
			logDisplayTextArea.appendText(Integer.toString(list.size()));
			assetTable.setItems(list);

		}

	}





}

// コントローラを完成させよう。！