package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private String nickName;
    private String password;
    public static Faction faction;

    public static ArrayList<String> playerNames = new ArrayList<>();
    public static HashMap<String , User> users = new HashMap<>();
    public static ArrayList<Card> cards = new ArrayList<>();

    public static String colorOfFaction;
    public static String nameOfLeader;

    public User(String name, String nickName, String password) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        playerNames.add(this.name);
        users.put(this.name , this);
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public Faction getFaction() {
        return faction;
    }

}