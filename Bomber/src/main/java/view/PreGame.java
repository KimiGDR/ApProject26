
package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class PreGame extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        PreGame.stage = stage;
        URL url = PreGame.class.getResource("/FXML/PreGame.fxml");
        BorderPane root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }
}