package ftt.app.infra.controllers;

import ftt.app.Main;
import ftt.app.application.DataFacade;
import ftt.app.domain.model.Interest;
import ftt.app.domain.model.User;
import ftt.app.infra.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

@Controller
public class SignIn {

	@Autowired
	private ApplicationContext springContext;

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

	@Autowired
	private UserService userService;

	@FXML
	void Login(ActionEvent event) {
		try {
			User current = userService.find(txtUser.getText().trim(), txtPassword.getText().trim());
			if (current != null) {
				Main.currentUser = current;
				Stage currentStage = (Stage) link_register.getScene().getWindow();
				currentStage.hide();

				FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/components/Home/Home.fxml"));
				homeLoader.setControllerFactory(springContext::getBean);
				Parent root = homeLoader.load();
				Home controller = homeLoader.<Home>getController();
				controller.setNews(loadNews(current));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Newtion - A new way to find relevant information.");
				stage.show();
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
		try {
			Stage currentStage = (Stage) link_register.getScene().getWindow();
			currentStage.hide();
			Main.SignUp.show();

			FXMLLoader singUpLoader = new FXMLLoader(getClass().getResource("/components/SignUp/SignUp.fxml"));
			singUpLoader.setControllerFactory(springContext::getBean);
			Parent root = singUpLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Newtion - A new way to find relevant information.");
			stage.show();
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

	private JSONObject loadNews(User user) throws Exception {
		DataFacade dataFacade = new DataFacade();
		Collection<Interest> interests = user.getInterests();
//		String interest = interests.toArray(new Interest[interests.size()])[0].getDescription();
		return dataFacade.getAllNews("business");
	}
}
