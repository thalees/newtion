package app;

import app.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
public class Main extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    private FXMLLoader fxmlLoader;

    public static User currentUser;
    public static Stage SignIn;
    public static Stage SignUp;
    public static Stage Interests;
    public static Stage Home;
    public static Stage SourcePlatforms;
    public static Stage NewsContent;
    public static Stage ProfileAndSettings;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            currentUser = new User();

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

    @Override
    public void stop() {
        springContext.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
