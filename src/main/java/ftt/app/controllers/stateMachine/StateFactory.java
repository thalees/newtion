package app.controllers.stateMachine;

import app.enums.AvailableStates;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class StateFactory {
	
	final String generateParentUrl(AvailableStates state) {
//		String defaultViewPath = "../../views/";
		String defaultViewPath = System.getProperty("user.dir") + "\\src\\views\\";
		switch (state) {
		case SignIn:
			return (defaultViewPath + "SingIn.fxml");
			
		case SignUp:
			return (defaultViewPath + "SingUp.fxml");

		default:
			return (defaultViewPath + "SingIn.fxml");
		}
	}
	
	final Stage getStage(AvailableStates state) throws IOException {
		String urlRoot = generateParentUrl(state);
		Parent root = FXMLLoader.load(getClass().getResource(urlRoot));
		Stage stage= new Stage(); 
		stage.setScene(new Scene(root));
		stage.setTitle("Newtion - A new way to find relevant information.");
		return stage;
	}
}
