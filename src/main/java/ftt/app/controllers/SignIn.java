package ftt.app.controllers;

import app.Main;
import ftt.app.adapters.DataFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignIn extends StandartController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnLogin;

	@FXML
	private Hyperlink link_register;

	@FXML
	private TextField txtPassword;

	@FXML
	private TextField txtUser;

	private DataFacade dataFacade = new DataFacade();

	@FXML
	void Login(ActionEvent event) {
		StandartController.showAlert("Data", dataFacade.getNewsInformation(), AlertType.INFORMATION);
		try {
			if (txtUser.getText().equals("admin") && txtPassword.getText().equals("admin")) {
				Main.Home.show();
				Stage currentStage = (Stage) link_register.getScene().getWindow();
				currentStage.hide();
			} else {
				StandartController.showAlert(">>> Error", "User or password incorrect", AlertType.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void changeToSingUp(ActionEvent event) {
		StandartController.showAlert("Data", dataFacade.getNewsInformation(), AlertType.INFORMATION);
		Stage stage = null;

		try {

			Stage currentStage = (Stage) link_register.getScene().getWindow();
			currentStage.hide();
			Main.SignUp.show();
			

			/*
			 * Parent root =
			 * FXMLLoader.load(getClass().getResource("../views/SingUp.fxml")); stage = new
			 * Stage(); stage.setScene(new Scene(root));
			 * stage.setTitle("Newtion - A new way to find relevant information.");
			 * stage.show();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initialize() {
		assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'SingIn.fxml'.";
		assert link_register != null : "fx:id=\"link_register\" was not injected: check your FXML file 'SingIn.fxml'.";
		assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'SingIn.fxml'.";
		assert txtUser != null : "fx:id=\"txtUser\" was not injected: check your FXML file 'SingIn.fxml'.";
	}

}
