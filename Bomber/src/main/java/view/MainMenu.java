package view;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import model.App;

import java.io.IOException;
import java.net.URL;

public class MainMenu extends Application {
    MainController controller = new MainController();
    public void start(Stage stage) throws IOException {
        URL url = Main.class.getResource("/FXML/Main.fxml");
        assert url != null;
        Pane root = FXMLLoader.load(url);
        Text text = new Text();
        text.setText(App.getLoggedInUser().getUsername());
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.relocate(260, 100);
        root.getChildren().add(text);

        Rectangle rectangle = new Rectangle(270, 30, 50,50);
        root.getChildren().add(rectangle);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToProfileMenu() throws Exception {
        (new ProfileMenu()).start(Main.stage);
    }
    public void logout() throws Exception {
        (new StartMenu()).start(Main.stage);
    }

}
