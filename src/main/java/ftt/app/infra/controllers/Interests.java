package ftt.app.infra.controllers;

import app.Main;
import ftt.app.domain.model.Interest;
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

public class Interests {

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
	private CheckBox chkCreativity;

	@FXML
	private CheckBox chkEconomy;

	@FXML
	private CheckBox chkInnovation;

	@FXML
	private CheckBox chkInvestment;

	@FXML
	private CheckBox chkNature;

	@FXML
	private CheckBox chkPolitics;

	@FXML
	private CheckBox chkPop;

	@FXML
	private CheckBox chkScience;

	@FXML
	private CheckBox chkSport;

	@FXML
	private CheckBox chkTechnology;

	@FXML
	private CheckBox chkTravel;

	@FXML
	private CheckBox chkWorld;

	@FXML
	void BackToRegistration(ActionEvent event) {
		try {
			Stage currentStage = (Stage) btnClear.getScene().getWindow();
			currentStage.hide();
			Main.SignUp.show();
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void ClearInterest(ActionEvent event) {
		chks.forEach(chk -> chk.setSelected(false));
	}

	private boolean validateInterests() {
		for (CheckBox chk : chks) {
			if (chk != null && chk.isSelected()) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<Interest> getInterests() {
		ArrayList<Interest> selectedInterests = new ArrayList<Interest>();
		for (CheckBox chk : chks) {
			if (chk != null && chk.isSelected()) {
				String interest = chk.getId().replace("chk", "");
				Interest enumInterest = new Interest(interest);
				selectedInterests.add(enumInterest);
			}
		}
		return selectedInterests;
	}

	@FXML
	void ContinueToNewsPlataforms(ActionEvent event) {
		try {
			if (validateInterests()) {
				Stage currentStage = (Stage) btnClear.getScene().getWindow();
				Main.currentUser.setInterests(this.getInterests());
				currentStage.hide();
				Main.SourcePlatforms.show();
			} else {
				StandartController.showAlert("Interests not found", "Please, mark at least one of the interests shown",
						AlertType.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void toggleInterest(ActionEvent event) {

	}

	@FXML
	void initialize() {
		this.chks = new HashSet<CheckBox>(Arrays.asList(
				chkCreativity, 
				chkEconomy, 
				chkInnovation, 
				chkInvestment,
				chkNature, 
				chkPolitics,
				chkPop,
				chkScience, 
				chkSport,
				chkTechnology,
				chkTravel,
				chkWorld));

		assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Interests.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Interests.fxml'.";
		assert btnContinue != null : "fx:id=\"btnContinue\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkCreativity != null : "fx:id=\"chkCreativity\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkEconomy != null : "fx:id=\"chkEconomy\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkInnovation != null : "fx:id=\"chkInnovation\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkInvestment != null : "fx:id=\"chkInvestment\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkNature != null : "fx:id=\"chkNature\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkPolitics != null : "fx:id=\"chkPolitics\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkPop != null : "fx:id=\"chkPop\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkScience != null : "fx:id=\"chkScience\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkSport != null : "fx:id=\"chkSport\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkTechnology != null : "fx:id=\"chkTechnology\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkTravel != null : "fx:id=\"chkTravel\" was not injected: check your FXML file 'Interests.fxml'.";
		assert chkWorld != null : "fx:id=\"chkWorld\" was not injected: check your FXML file 'Interests.fxml'.";
	}
}
