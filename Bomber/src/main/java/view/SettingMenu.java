package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SettingMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = Main.class.getResource("/FXML/Setting.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void backToMain(MouseEvent mouseEvent) throws IOException {
        (new MainMenu()).start(Main.stage);
    }
}
