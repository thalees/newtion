package ftt.app.infra.controllers;

import com.google.gson.Gson;
import ftt.app.Main;
import ftt.app.application.DataFacade;
import ftt.app.domain.model.DataResponse;
import ftt.app.domain.model.News;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

@Controller
public class Home {
    JSONObject data;

    @Autowired
    private ApplicationContext springContext;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label newsTitle1;

    @FXML
    private Label newsDescription1;

    @FXML
    private Pane panelImage1;

    @FXML
    private Label newsTitle2;

    @FXML
    private Label newsDescription2;

    @FXML
    private Pane panelImage2;

    @FXML
    private Label newsTitle3;

    @FXML
    private Label newsDescription3;

    @FXML
    private Pane panelImage3;

    @FXML
    private Label newsTitle4;

    @FXML
    private Label newsDescription4;

    @FXML
    private Pane panelImage4;

    @FXML
    private Label newsTitle5;

    @FXML
    private Label newsDescription5;

    @FXML
    private Pane panelImage5;

    @FXML
    private Label newsTitle6;

    @FXML
    private Label newsDescription6;

    @FXML
    private Pane panelImage6;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnMenu;

    @FXML
    private TextField txtSearch;


    @FXML
    void openNewsContent(Event event) {
    	try {
			Stage currentStage = (Stage) panelImage1.getScene().getWindow();
			currentStage.hide();

            FXMLLoader newsContentLoader = new FXMLLoader(getClass().getResource("/components/NewsContent.fxml"));
            newsContentLoader.setControllerFactory(springContext::getBean);
            Parent root = newsContentLoader.load();
            NewsContent controller = newsContentLoader.<NewsContent>getController();
            controller.setNewsToRead(data, getIndex(event.getSource().toString()));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Main.NewsContent = stage;

            stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			StandartController.showAlert(">>> Error: ", e.getMessage(), AlertType.ERROR);
		}
    }

    @FXML
    void search(ActionEvent event) {
        String text = txtSearch.getText();
    	try {
            Stage currentStage = (Stage) txtSearch.getScene().getWindow();
			currentStage.hide();

            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/components/Home/Home.fxml"));
            homeLoader.setControllerFactory(springContext::getBean);
            Parent root = homeLoader.load();
            Home controller = homeLoader.<Home>getController();
            controller.setNews(searchNews(text));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Main.Home = stage;

			stage.show();
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
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'Home.fxml'.";
        assert newsTitle1 != null : "fx:id=\"newsTitle\" was not injected: check your FXML file 'SingIn.fxml'.";
        assert newsDescription1 != null : "fx:id=\"newsDescription\" was not injected: check your FXML file 'SingIn.fxml'.";
    }

    private JSONObject searchNews(String text) throws Exception {
        DataFacade dataFacade = new DataFacade();
        data = dataFacade.searchNewsByText(text);

        return data;
    }

    public void setNews(JSONObject newsObject) throws JSONException {
        data = newsObject;

        Pane[] panes = buildPanes();
        Label[] titles = buildTitles();
        Label[] descriptions = buildDescriptions();

        Gson gson = new Gson();
        DataResponse response = gson.fromJson(newsObject.toString(), DataResponse.class);
        Collection<News> news = response.getArticles();

        for(int i = 0; i < 6 ; i++){
            titles[i].setText(news.toArray(new News[news.size()])[i].getTitle());
            descriptions[i].setText(news.toArray(new News[news.size()])[i].getDescription());

            panes[i].setStyle(
                "-fx-background-image: url('" + news.toArray(new News[news.size()])[i].getUrlToImage() + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;"
            );
        }

    }

    private int getIndex(String className){
        return Integer.parseInt((className.substring(className.length() - 2, className.length() - 1) ).trim()) - 1;
    }

    private Label[] buildTitles(){
        return new Label[]{
            newsTitle1, newsTitle2, newsTitle3, newsTitle4, newsTitle5, newsTitle6
        };
    }

    private Label[] buildDescriptions(){
        return new Label[]{
                newsDescription1, newsDescription2, newsDescription3, newsDescription4, newsDescription5, newsDescription6
        };
    }

    private Pane[] buildPanes(){
        return new Pane[]{
                panelImage1, panelImage2, panelImage3, panelImage4, panelImage5, panelImage6
        };
    }
}
