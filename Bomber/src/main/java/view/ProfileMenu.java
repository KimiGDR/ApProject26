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

public class ProfileMenu extends Application {
    public TextField newPassword;
    public TextField oldPassword;
    public TextField newUsername;
    public TextField newEmail;
    public TextField newNickname;
    ProfileController controller = new ProfileController();

    @Override
    public void start(Stage stage) throws Exception {
        URL url = Main.class.getResource("/FXML/Profile.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void backToMain() throws IOException {
        (new MainMenu()).start(Main.stage);
    }

    public void changeUsername() {
        Result result = controller.changeUsername(newUsername.getText());
        if (!result.isSuccessful()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("error changing username");
            alert.setContentText(result.toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("change successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();
        }
    }

    public void changePassword() {
        Result result = controller.changePassword(newPassword.getText(), oldPassword.getText());
        if (!result.isSuccessful()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("error changing password");
            alert.setContentText(result.toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("change successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();
        }
    }

    public void changeEmail(MouseEvent mouseEvent) {
        Result result = controller.changeEmail(newEmail.getText());
        if (!result.isSuccessful()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("error changing email");
            alert.setContentText(result.toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("change successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();
        }
    }

    public void changeNickname(MouseEvent mouseEvent) {
        Result result = controller.changeNickname(newNickname.getText());
        if (!result.isSuccessful()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("error changing nickname");
            alert.setContentText(result.toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("change successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();
        }
    }

    public void goInfo(MouseEvent mouseEvent) throws Exception {
        (new Userinfo()).start(Main.stage);
    }
}
