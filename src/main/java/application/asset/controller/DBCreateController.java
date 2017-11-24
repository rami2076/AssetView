package application.asset.controller;

import java.util.function.Predicate;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import application.asset.main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.control.Button;

public class DBCreateController {

	@FXML
	private TextField userNameField;
	@FXML
	private Button isValidButton;
	@FXML
	private Button registerButton;
	@FXML
	private TextArea logArea;
	@FXML
	private MainApp mainApp;

	@FXML
	public void isValid() {

	}

	@FXML
	public void register() {

	}

	@FXML
	public void initialize() {
		ValidationSupport support = new ValidationSupport();
		Predicate<TextField> textPredicate = s -> s.toString().length() > 0;
		support.registerValidator(userNameField, false,
				Validator.createPredicateValidator(textPredicate, "Text is required", Severity.WARNING));
		// refer
		// https://qiita.com/monolith52/items/5a11ef104b0160229734
	}

	@FXML
	public void setMainApp() {

	}

}
