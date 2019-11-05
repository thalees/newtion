package ftt.app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Home {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnImgOpenNewsBody;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnMenu;

    @FXML
    private TextField txtSearch;


    @FXML
    void openNewsContent(Event event) {
    	try {
			Stage currentStage = (Stage) btnImgOpenNewsBody.getScene().getWindow();
			currentStage.hide();
			Main.NewsContent.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void search(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) txtSearch.getScene().getWindow();
			currentStage.hide();
			txtSearch.setText("");
			Main.Home.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void openProfileAndSettings(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) txtSearch.getScene().getWindow();
			currentStage.hide();
			Main.ProfileAndSettings.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void initialize() {
        assert btnImgOpenNewsBody != null : "fx:id=\"btnImgOpenNewsBody\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'Home.fxml'.";


    }

}
