package ftt.app.infra.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StandartController {
	private static Alert alert = new Alert(AlertType.NONE);
	
	public static void showAlert(String title, String message, AlertType type) {
		alert.setHeaderText(title);
		alert.setContentText(message);
		alert.setAlertType(type);
		alert.show();
	}
	
}
