package model;

import javafx.scene.image.Image;
import view.Main;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nicknmae;
    private String email;
    private String securityQuestion;
    private String securityAnswer;

    private Image avatar = new Image(String.valueOf(Main.class.getResource("/images/Avatar2.png")));
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, String nickname, String email, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.nicknmae = nicknmae;
        this.email = email;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        allUsers.add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }

    public String getNicknmae() {
        return nicknmae;
    }

    public String getEmail() {
        return email;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setNicknmae(String nicknmae) {
        this.nicknmae = nicknmae;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User getUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
