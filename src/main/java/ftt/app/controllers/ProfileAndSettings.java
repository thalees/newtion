package app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileAndSettings {

	private String defaultMessage = "We also don't like long registration forms.\n"
			+ "But please enter the required data in the following " + "fields: Username, Email and Password.";
	private String specificMessage;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnMenu;

    @FXML
    private Button btnToggleSideMenu;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

    private boolean validationFields() {
		this.specificMessage = "";
		boolean isValid = true;
		if (this.txtUserName.getText().trim().equals("")) {
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
    void save(ActionEvent event) {
    	String name = txtUserName.getText().trim();
    	String email = txtEmail.getText().trim();
    	String password = txtPassword.getText().trim();
    	
    	if (validationFields()) {
			Main.currentUser.setName(name);
	    	Main.currentUser.setEmail(email);
	    	Main.currentUser.setPassword(password);
	    	StandartController.showAlert("Success!", "Your information has been updated with success.", AlertType.INFORMATION);
		} else {
			StandartController.showAlert(defaultMessage, specificMessage, AlertType.ERROR);
		}
    	
    	
    }

    
    @FXML
    void returnToHome(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) btnSave.getScene().getWindow();
			currentStage.hide();
			Main.Home.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }
    
    @FXML
    void openProfileAndSettings(ActionEvent event) {
    	System.out.println("Test");
    	try {
			Stage currentStage = (Stage) btnSave.getScene().getWindow();
			currentStage.hide();
			Main.ProfileAndSettings.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void toggleSideMenu(ActionEvent event) {
    }

    @FXML
    void initialize() {
    	if(Main.currentUser != null) {
        	txtUserName.setText(Main.currentUser.getName());
        	txtEmail.setText(Main.currentUser.getEmail());
        	txtPassword.setText(Main.currentUser.getPassword());
        }
    	
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'Profile.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Profile.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Profile.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Profile.fxml'.";
        assert txtUserName != null : "fx:id=\"txtUserName\" was not injected: check your FXML file 'Profile.fxml'.";
    }

}
