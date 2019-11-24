package ftt.app.infra.controllers;

import ftt.app.Main;
import ftt.app.application.DataFacade;
import ftt.app.domain.model.Interest;
import ftt.app.domain.model.Platform;
import ftt.app.domain.model.User;
import ftt.app.infra.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

@Controller
public class SourcePlatforms {
	private HashSet<CheckBox> chks;

    @Autowired
    private ApplicationContext springContext;

    @Autowired
    private UserService userService;
	
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

	private ArrayList<Platform> getSourcePlatforms() {
		ArrayList<Platform> selectedPlatforms = new ArrayList<Platform>();
		for (CheckBox chk : chks) {
			if (chk != null && chk.isSelected()) {
				String platform = chk.getId().replace("chk", "");
				Platform enumPlatform = new Platform(platform);
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
//				Main.currentUser.setPlatforms(this.getSourcePlatforms());
				currentStage.hide();
				Main.SourcePlatforms.show();
			} else {
				StandartController.showAlert("Source platforms not found", "Please, mark at least one of the source platforms shown",
						AlertType.ERROR);
			}
			Stage currentStage = (Stage) btnClear.getScene().getWindow();
			currentStage.hide();

            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/components/Home/Home.fxml"));
            homeLoader.setControllerFactory(springContext::getBean);
            Parent root = homeLoader.load();
            Home controller = homeLoader.<Home>getController();
            controller.setNews(loadNews(Main.currentUser));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Newtion - A new way to find relevant information.");
            stage.show();
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

    private JSONObject loadNews(User user) throws Exception {
        DataFacade dataFacade = new DataFacade();
        Collection<Interest> interests = user.getInterests();
//		String interest = interests.toArray(new Interest[interests.size()])[0].getDescription();
        return dataFacade.getAllNews("business");
    }
}
