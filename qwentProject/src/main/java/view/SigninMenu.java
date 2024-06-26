package view;

import controller.SigninController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Result;

import java.net.URL;
import java.security.SecureRandom;

public class SigninMenu extends Application {
    public TextField username;
    public PasswordField password;
    public PasswordField passwordConfirm;
    public TextField nickname;
    public TextField email;
    public TextField securityAnswer;
    SigninController controller = new SigninController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = Main.class.getResource("/FXML/Signin.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void backToStart() throws Exception {
        (new StartMenu()).start(Main.stage);
    }

    public void checkInfo() throws Exception {

        String username = this.username.getText();
        String password = this.password.getText();
        String passConfirm = this.passwordConfirm.getText();
        String email = this.email.getText();
        String nickname = this.nickname.getText();
        String securityAnswer = this.securityAnswer.getText();


        Result result = controller.checkInfo(username, password, passwordConfirm.getText(), nickname, email);

        if (result.toString().equals("randomPassword")) {
            PasswordField randomPass = null;
            randomPass.setText(generateRandomPassword());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Random Password Generated");
            alert.setContentText("Generated Password: " + randomPass + "\nDo you want to use this password?");
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");
            alert.getButtonTypes().setAll(yesButton, noButton);
            alert.showAndWait().ifPresent(response -> {
                if (response == yesButton) {
                    this.password = randomPass;
                    this.passwordConfirm = randomPass;
                } else {
                    this.password.setText("");
                    this.passwordConfirm.setText("");
                }
            });

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Registration Failed");
            alert.setContentText(String.valueOf(result));
            alert.showAndWait();
        }
        if(result.isSuccessful())
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("error signing in");
        alert.setHeaderText("can't sign in.");
        alert.setContentText(result.toString());
        alert.show();
    } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("sign in successfully");
            alert.setHeaderText(":)");
            alert.setContentText(result.toString());
            alert.show();

            try {
                (new StartMenu()).start(Main.stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public String generateRandomPassword() {
        String specialChars = "!@#$&*";
        String digits = "0123456789";
        String chars = "ZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();


        for (int i = 0; i < 2; i++) {
            password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }
        for (int i = 0; i < 4; i++) {
            password.append(digits.charAt(random.nextInt(digits.length())));
        }
        for (int i = 0; i < 6; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }
}
