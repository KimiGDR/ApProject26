package model;

import javafx.scene.image.Image;
import view.Main;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nicknmae;
    private String email;
    private int indexBackground = 1;

    private Image avatar = new Image(String.valueOf(Main.class.getResource("/images/Avatar2.png")));
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nicknmae = nicknmae;
        this.email = email;
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

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public int getIndexBackground() {
        return this.indexBackground;
    }

    public void setIndexBackground(int indexBackground) {
        this.indexBackground = indexBackground;
    }
}
