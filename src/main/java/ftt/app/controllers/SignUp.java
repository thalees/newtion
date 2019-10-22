package app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import app.model.User;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {

	private String defaultMessage = "We also don't like long registration forms.\n"
			+ "But please enter the required data in the following " + "fields: Username, Email and Password.";
	private String specificMessage;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRegister;

	@FXML
	private Hyperlink link_sing_in;

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUsername;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	private boolean validationFields() {
		this.specificMessage = "";
		boolean isValid = true;
		if (this.txtUsername.getText().trim().equals("")) {
			this.specificMessage = "Username should be different than a white space.\n";
			isValid = false;
		}
		if (this.txtEmail.getText().trim().equals("")) {
			this.specificMessage += "Enter an email different than a white space.\n";
			isValid = false;
		}
		if (!validateEmail(this.txtEmail.getText().trim())) {
			this.specificMessage += "Use a valid email. (Example: test_email@domain.com).\n";
			isValid = false;
		}
		if (this.txtPassword.getText().trim().equals("")) {
			this.specificMessage += "Insert a password different than a white space.\n";
			isValid = false;
		}
		if (this.txtPassword.getText().trim().length() < 6 || this.txtPassword.getText().trim().length() > 30) {
			this.specificMessage += "Password should have at least six characters and at most thirty characters.\n";
			isValid = false;
		}

		return isValid;
	}

	@FXML
	void StartRegistration(ActionEvent event) {
		try {
			if (validationFields()) {
				Stage currentStage = (Stage) link_sing_in.getScene().getWindow();
				currentStage.hide();
				String name = this.txtUsername.getText().trim();
				String email = this.txtEmail.getText().trim();
				String password = this.txtPassword.getText().trim();
				Main.currentUser = new User(name, email, password);
				Main.Interests.show();
			} else {
				StandartController.showAlert(defaultMessage, specificMessage, AlertType.ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void backToSingIn(ActionEvent event) {
		try {
			Stage currentStage = (Stage) link_sing_in.getScene().getWindow();
			currentStage.hide();
			Main.SignIn.show();
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initialize() {
		assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'SingUp.fxml'.";
		assert link_sing_in != null : "fx:id=\"link_sing_in\" was not injected: check your FXML file 'SingUp.fxml'.";
		assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'SignUp.fxml'.";
		assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'SignUp.fxml'.";
		assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'SignUp.fxml'.";

	}

}
