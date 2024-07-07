package view;

import controller.Logincontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Result;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class LoginMenu extends Application {
    public TextField username;
    public TextField password;
    Logincontroller controller = new Logincontroller();

    @Override
    public void start(Stage stage) throws Exception {
        URL url = Main.class.getResource("/FXML/Login.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void backToStart() throws Exception {
        (new StartMenu()).start(Main.stage);
    }

    public void checkInfo() throws IOException {
        Result result = controller.checkInfo(username.getText(), password.getText());
        if (!result.isSuccessful()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("error login in");
            alert.setHeaderText("can't login.");
            alert.setContentText(result.toString());
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("login successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();
            (new MainMenu()).start(Main.stage);
        }
    }

    public boolean isPasswordValid(String password) {
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (!password.matches(passwordPattern)) {
            return false;
        }
        return true;
    }

    public void forgotPassword(MouseEvent mouseEvent) {

        if (username.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please enter your username");
            alert.showAndWait();
        }
        User user = User.getUserByUsername(username.getText());
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("User not found");
            alert.showAndWait();
        }
        String securityQuestion = user.getSecurityQuestion();

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Forgot Password");
        dialog.setHeaderText(securityQuestion);
        dialog.setContentText("Please enter your answer:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String answer = result.get();
            if (answer.equals(user.getSecurityAnswer())) {

                dialog = new TextInputDialog();
                dialog.setTitle("Reset Password");
                dialog.setHeaderText("Enter your new password:");
                dialog.setContentText("New password:");

                Optional<String> newPassword = dialog.showAndWait();
                if (newPassword.isPresent()) {
                    if (isPasswordValid(newPassword.get())) {
                        user.setPassword(newPassword.get());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Password reset successfully");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Password must contain at least 8 characters, one letter, one number and one special character");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Incorrect answer");
                    alert.showAndWait();
                }
            }
        }
    }
}
