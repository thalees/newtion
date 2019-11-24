package ftt.app.infra.controllers;

import com.google.gson.Gson;
import ftt.app.Main;
import ftt.app.domain.model.DataResponse;
import ftt.app.domain.model.News;
import ftt.app.infra.repositories.NewsRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.ResourceBundle;

@Controller
public class NewsContent {

    @Autowired
    private NewsRepository newsRepository;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Label txtTitle;

    @FXML
    private Label txtContent;

    @FXML
    private Pane BannerImage;

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

    public void setNewsToRead(JSONObject data, int index){
        Gson gson = new Gson();
        DataResponse response = gson.fromJson(data.toString(), DataResponse.class);
        Collection<News> newsCollection = response.getArticles();

        News[] newsArray = newsCollection.toArray(new News[newsCollection.size()]);

        newsRepository.saveAndFlush(newsArray[index]);

        txtTitle.setText(newsArray[index].getTitle());
        txtContent.setText(newsArray[index].getContent());

        BannerImage.setStyle(
                "-fx-background-image: url('" + newsArray[index].getUrlToImage() + "'); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;"
        );
    }
}
