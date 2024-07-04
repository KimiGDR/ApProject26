package view;

import controller.ProfileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Result;

import java.io.IOException;
import java.net.URL;

public class PreGameMenu extends Application {
    public TextField newPassword;
    public TextField newUsername;
    ProfileController controller = new ProfileController();

    @Override
    public void start(Stage stage) throws Exception {
        URL url = Main.class.getResource("/FXML/PreGame.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }
}