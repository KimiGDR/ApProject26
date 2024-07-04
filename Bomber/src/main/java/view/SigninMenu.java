package view;

import controller.SigninController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public ChoiceBox<String> securityQuestion;
    public TextField securityAnswer;
    private String generatedPassword;
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
        String email = this.email.getText();
        String nickname = this.nickname.getText();
        String securityQuestion = this.securityQuestion.getValue();
        String securityAnswer = this.securityAnswer.getText();
        String password = this.password.getText();
        String passwordConfirm = this.passwordConfirm.getText();

        Result result = controller.checkInfo(username, password, passwordConfirm, nickname, email, securityQuestion, securityAnswer);

        if (result.toString().equals("generateRandomPassword")) {
            generatedPassword = generateRandomPassword().getText();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Random Password Generated");
            alert.setContentText("Generated Password: " + generatedPassword + "\nDo you want to use this password?");
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");
            alert.getButtonTypes().setAll(yesButton, noButton);
            Result finalResult = result;
            alert.showAndWait().ifPresent(response -> {
                if (response == yesButton) {
                    this.password.setText(generatedPassword);
                    this.passwordConfirm.setText(generatedPassword);
                } else {
                    this.password.setText("");
                    this.passwordConfirm.setText("");
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText("Registration Failed");
                    alerta.setContentText(finalResult.toString());
                    alerta.showAndWait();
                }

            });
            result = controller.checkInfo(username, password, passwordConfirm, nickname, email, securityQuestion, securityAnswer);
        }
        //Result results = controller.checkInfo(username, password, passwordConfirm, nickname, email, securityQuestion, securityAnswer);
        if (!result.isSuccessful()) {
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
            new StartMenu(). start(Main.stage);
            try {
                (new StartMenu()).start(Main.stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public PasswordField generateRandomPassword() {
        String specialChars = "!@#$&*";
        String digits = "0123456789";
        String chars = "ZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY";
        PasswordField password = new PasswordField();
        SecureRandom random = new SecureRandom();


        for (int i = 0; i < 2; i++) {
            password.appendText(String.valueOf(specialChars.charAt(random.nextInt(specialChars.length()))));
        }
        for (int i = 0; i < 4; i++) {
            password.appendText(String.valueOf(digits.charAt(random.nextInt(digits.length()))));
        }
        for (int i = 0; i < 6; i++) {
            password.appendText(String.valueOf(chars.charAt(random.nextInt(chars.length()))));
        }
        return password;
    }
}
