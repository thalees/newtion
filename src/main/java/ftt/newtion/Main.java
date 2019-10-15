package ftt.newtion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import  javafx.scene.control.Label;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello world");
        Scene scene = new Scene(label);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
