package ftt.app.infra.controllers;

import ftt.app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class NewsContent {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnFavNew;
    
    @FXML
    private Button btnMenu;


    @FXML
    void returnToHome(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) btnFavNew.getScene().getWindow();
			currentStage.hide();
			Main.Home.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }
    
    @FXML
    void toggleFavoritation(ActionEvent event) {
    	if(btnFavNew.getTextFill() == Paint.valueOf("gray")) {
    		btnFavNew.setTextFill(Paint.valueOf("#ff3333"));
    	}else {
    		btnFavNew.setTextFill(Paint.valueOf("gray"));
    	}
    }
    
    @FXML
    void openProfileAndSettings(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) btnFavNew.getScene().getWindow();
			currentStage.hide();
			Main.ProfileAndSettings.show();		
			 
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void initialize() {
        assert btnFavNew != null : "fx:id=\"btnFavNew\" was not injected: check your FXML file 'NewsContent.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'NewsContent.fxml'.";
    }

}
