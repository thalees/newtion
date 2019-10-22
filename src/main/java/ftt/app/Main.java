package app;

import app.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static User currentUser;
    public static Stage SignIn;
    public static Stage SignUp;
    public static Stage Interests;
    public static Stage Home;
    public static Stage SourcePlatforms;
    public static Stage NewsContent;
    public static Stage ProfileAndSettings;

    @Override
    public void start(Stage primaryStage) {
        try {

            /* User */
            currentUser = new User();

            /* Sing Up */
            Parent rootSignUp = FXMLLoader.load(getClass().getResource("/components/SignUp.fxml"));
            SignUp = new Stage();
            SignUp.setTitle("Newtion - A new way to find relevant information.");
            SignUp.setScene(new Scene(rootSignUp));

            /* Sing In */
            Parent rootSingIn = FXMLLoader.load(getClass().getResource("/components/SignIn.fxml"));
            SignIn = new Stage();
            SignIn.setTitle("Newtion - A new way to find relevant information.");
            SignIn.setScene(new Scene(rootSingIn));

            /* Interests */
            Parent rootInterests = FXMLLoader.load(getClass().getResource("/components/Interests.fxml"));
            Interests = new Stage();
            Interests.setTitle("Newtion - A new way to find relevant information.");
            Interests.setScene(new Scene(rootInterests));

            /* Home */
            Parent rootHome = FXMLLoader.load(getClass().getResource("/components/Home.fxml"));
            Home = new Stage();
            Home.setScene(new Scene(rootHome));

            /* Source Platforms */
            Parent rootPlatforms = FXMLLoader.load(getClass().getResource("/components/SourcePlatforms.fxml"));
            SourcePlatforms = new Stage();
            SourcePlatforms.setScene(new Scene(rootPlatforms));

            /* News content */
            Parent rootNewsContent = FXMLLoader.load(getClass().getResource("/components/NewsContent.fxml"));
            NewsContent = new Stage();
            NewsContent.setScene(new Scene(rootNewsContent));

            /* Profile and Settings */
            Parent rootProfileAndSettings = FXMLLoader
                    .load(getClass().getResource("/components/ProfileAndSettings.fxml"));
            ProfileAndSettings = new Stage();
            ProfileAndSettings.setScene(new Scene(rootProfileAndSettings));

            SignIn.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
