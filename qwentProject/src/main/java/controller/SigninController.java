package controller;

import javafx.scene.control.Alert;
import model.Result;
import model.User;

import java.security.SecureRandom;

public class SigninController {
    public Result checkInfo(String username, String password, String passwordConfirm, String nickname, String email) {
        if (!isUsernameValid(username)) return new Result(false, "invalid username, please enter valid username");
        if (isUserExit(username))
            return new Result(false, "this username had already used, please enter another username");
        if (!isPasswordValid(password)) return new Result(false, "weak password");
        if (!password.equals(passwordConfirm)) return new Result(false, "password confirm is not the same");
        if (!isNicknameValid(nickname)) return new Result(false, "invalid nickname, please enter valid nickname");
        if (!isEmailValid(email)) return new Result(false, "invalid email, please enter valid email");

        User user = new User(username, password, nickname, email);
        return new Result(true, "signin Succesful");
    }

    private boolean isEmailValid(String email) {
        if (email.isEmpty()) return false;
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) return false;
        return true;
    }

    private boolean isUsernameValid(String username) {
        if (username.isEmpty()) return false;
        if (!username.matches("[a-zA-Z_-]*")) return false;
        return true;
    }

    private boolean isRandomPassword(String password) {
        if (password.equals("random")) {
            return true;
        }
        return false;
    }


    private boolean isUserExit(String username) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordValid(String password) {
        if (password.isEmpty()) return false;
        if (password.length() < 6) return false;
        if (!password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*")) return false;
        return true;
    }

    private boolean isNicknameValid(String nickname) {
        if (nickname.isEmpty()) return false;
        if (!nickname.matches("[a-zA-Z_]*")) return false;
        return true;
    }

}