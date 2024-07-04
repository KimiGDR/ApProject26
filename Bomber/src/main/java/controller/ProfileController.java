package controller;

import model.App;
import model.Result;
import model.User;

import java.lang.ref.SoftReference;

public class ProfileController {
    public Result changeUsername(String newUsername) {
        if (newUsername.isEmpty()) return new Result(false, "please enter a username");

        if (newUsername.equals(App.getLoggedInUser().getUsername()))
            return new Result(false, "new name is same with current name");

        if (isUserExit(newUsername)) return new Result(false,
                "there is a User with this username, please enter another username");
        if (!isUsernameValid(newUsername))
            return new Result(false, "invalid username");


        App.getLoggedInUser().setUsername(newUsername);
        return new Result(true, "username change successfully");
    }

    public Result changePassword(String newPassword, String oldPassword) {
        if(!oldPassword.equals(App.getLoggedInUser().getPassword()))
            return new Result(false, "the old password is wrong");
        else if (newPassword.equals(App.getLoggedInUser().getPassword()))
            return new Result(false, "new password is same with current name");
        if (!isPasswordValid(newPassword))
            return new Result(false, "invalid password");
        App.getLoggedInUser().setPassword(newPassword);
        return new Result(true, "username change successfully");
    }
    public Result changeEmail(String newEmail){
        if(newEmail.equals(App.getLoggedInUser().getEmail()))
            return new Result(false, "new email is same with current email");
        else if (!isEmailValid(newEmail))
            return new Result(false, "invalid email");

        App.getLoggedInUser().setEmail(newEmail);
        return new Result(true, "email change successfully");
    }

    public Result changeNickname(String newNickname) {
        if (newNickname.equals(App.getLoggedInUser().getNicknmae()))
            return new Result(false, "new nickname is same with current nickname");
        else if (!isNicknameValid(newNickname))
            return new Result(false, "invalid nickname");
        App.getLoggedInUser().setNicknmae(newNickname);
        return new Result(true, "nickname change successfully");
    }

    private boolean isNicknameValid(String newNickname) {
        if (newNickname.isEmpty()) return false;
        if (!newNickname.matches("[a-zA-Z_]*")) return false;
        return true;
    }

    private boolean isUserExit(String username) {
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameValid(String username) {
        if (username.isEmpty()) return false;
        if (!username.matches("[a-zA-Z_]*")) return false;
        return true;
    }

    private boolean isPasswordValid(String password) {
        if (password.isEmpty()) return false;
        if (password.length() < 6) return false;
        if (!password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*")) return false;
        return true;
    }

    private boolean isEmailValid(String email){
        if (email.isEmpty()) return false;
        else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) return false;
        return true;
    }


}
