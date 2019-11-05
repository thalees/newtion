package ftt.app.controllers;

import app.Main;
import app.enums.AvailablePlatforms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;


public class SourcePlatforms {
	private HashSet<CheckBox> chks;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnContinue;
    @FXML
    private CheckBox chkAbril;

    @FXML
    private CheckBox chkBBC;

    @FXML
    private CheckBox chkDZone;

    @FXML
    private CheckBox chkExame;

    @FXML
    private CheckBox chkFolha;

    @FXML
    private CheckBox chkG1;

    @FXML
    private CheckBox chkGazeta;

    @FXML
    private CheckBox chkInfoQ;

    @FXML
    private CheckBox chkMedium;

    @FXML
    private CheckBox chkR7;

    @FXML
    private CheckBox chkStartSe;

    @FXML
    private CheckBox chkVeja;


    @FXML
    void backToInterests(ActionEvent event) {
    	try {
			Stage currentStage = (Stage) btnClear.getScene().getWindow();
			currentStage.hide();
			Main.Interests.show();
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void clearPlatformsSelected(ActionEvent event) {
    	chks.forEach(chk -> chk.setSelected(false));
    }
    
	private boolean validatePlatforms() {
		for (CheckBox chk : chks) {
			if (chk != null && chk.isSelected()) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<AvailablePlatforms> getSourcePlatforms() {
		ArrayList<AvailablePlatforms> selectedPlatforms = new ArrayList<AvailablePlatforms>();
		for (CheckBox chk : chks) {
			if (chk != null && chk.isSelected()) {
				String platform = chk.getId().replace("chk", "");
				AvailablePlatforms enumPlatform = AvailablePlatforms.valueOf(platform);
				selectedPlatforms.add(enumPlatform);
			}
		}
		return selectedPlatforms;
	}

    @FXML
    void finishRegistration(ActionEvent event) {
    	try {
    		if (this.validatePlatforms()) {
				Stage currentStage = (Stage) btnClear.getScene().getWindow();
				Main.currentUser.setPlatforms(this.getSourcePlatforms());
				currentStage.hide();
				Main.SourcePlatforms.show();
			} else {
				StandartController.showAlert("Source platforms not found", "Please, mark at least one of the source platforms shown",
						AlertType.ERROR);
			}
			Stage currentStage = (Stage) btnClear.getScene().getWindow();
			currentStage.hide();
			Main.Home.show();
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void initialize() {
    	
    	this.chks = new HashSet<CheckBox>(Arrays.asList(
    			chkAbril,
    	       chkBBC,
    	       chkDZone,
    	       chkExame,
    	       chkFolha,
    	       chkG1 ,
    	       chkGazeta ,
    	       chkInfoQ ,
    	       chkMedium,
    	       chkR7 ,
    	       chkStartSe ,
    	       chkVeja
    			));
    	
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert btnContinue != null : "fx:id=\"btnContinue\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkAbril != null : "fx:id=\"chkAbril\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkBBC != null : "fx:id=\"chkBBC\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkDZone != null : "fx:id=\"chkDZone\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkExame != null : "fx:id=\"chkExame\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkFolha != null : "fx:id=\"chkFolha\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkG1 != null : "fx:id=\"chkG1\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkGazeta != null : "fx:id=\"chkGazeta\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkInfoQ != null : "fx:id=\"chkInfoQ\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkMedium != null : "fx:id=\"chkMedium\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkR7 != null : "fx:id=\"chkR7\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkStartSe != null : "fx:id=\"chkStartSe\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";
        assert chkVeja != null : "fx:id=\"chkVeja\" was not injected: check your FXML file 'SourcePlatforms.fxml'.";


    }
}
