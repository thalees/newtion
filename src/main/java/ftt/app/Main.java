package ftt.app;

import ftt.app.domain.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
@EnableAutoConfiguration
@EntityScan(basePackages = {"ftt.app.domain.model"} )
@EnableJpaRepositories(basePackages = {"ftt.app.infra.repositories"})
public class Main extends Application {
    @Autowired
    private ConfigurableApplicationContext springContext;
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

            FXMLLoader singUpLoader = new FXMLLoader(getClass().getResource("/components/SignUp/SignUp.fxml"));
            singUpLoader.setControllerFactory(springContext::getBean);
            Parent rootSingUp = singUpLoader.load();
            SignUp = new Stage();
            SignUp.setTitle("Newtion - A new way to find relevant information.");
            SignUp.setScene(new Scene(rootSingUp));

            /* Sing In */
            FXMLLoader singInLoader = new FXMLLoader(getClass().getResource("/components/SignIn/SignIn.fxml"));
            singInLoader.setControllerFactory(springContext::getBean);
            Parent rootSingIn = singInLoader.load();
            SignIn = new Stage();
            SignIn.setTitle("Newtion - A new way to find relevant information.");
            SignIn.setScene(new Scene(rootSingIn));

            /* Interests */
            FXMLLoader interestsLoader = new FXMLLoader(getClass().getResource("/components/Interests/Interests.fxml"));
            interestsLoader.setControllerFactory(springContext::getBean);
            Parent rootInterests = interestsLoader.load();
            Interests = new Stage();
            Interests.setTitle("Newtion - A new way to find relevant information.");
            Interests.setScene(new Scene(rootInterests));

            /* Home */
            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/components/Home/Home.fxml"));
            homeLoader.setControllerFactory(springContext::getBean);
            Parent rootHome = homeLoader.load();
            Home = new Stage();
            Home.setScene(new Scene(rootHome));

            /* Source Platforms */
            FXMLLoader platformsLoader = new FXMLLoader(getClass().getResource("/components/SourcePlatforms/SourcePlatforms.fxml"));
            platformsLoader.setControllerFactory(springContext::getBean);
            Parent rootPlatforms = platformsLoader.load();
            SourcePlatforms = new Stage();
            SourcePlatforms.setScene(new Scene(rootPlatforms));

            /* News content */

            FXMLLoader newsContentLoader = new FXMLLoader(getClass().getResource("/components/NewsContent/NewsContent.fxml"));
            newsContentLoader.setControllerFactory(springContext::getBean);
            Parent rootNewsContent = newsContentLoader.load();
            NewsContent = new Stage();
            NewsContent.setScene(new Scene(rootNewsContent));

            /* Profile and Settings */
            FXMLLoader profileAndSettingsLoader = new FXMLLoader(getClass().getResource("/components/ProfileAndSettings/ProfileAndSettings.fxml"));
            profileAndSettingsLoader.setControllerFactory(springContext::getBean);
            Parent rootProfileAndSettings = profileAndSettingsLoader.load();
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
