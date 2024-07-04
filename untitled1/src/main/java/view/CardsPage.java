package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class CardsPage extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CardsPage.stage = stage;
        URL url = CardsPage.class.getResource("/FXML/CardsPage.fxml");
        BorderPane root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }
}