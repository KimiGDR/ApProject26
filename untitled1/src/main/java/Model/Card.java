package Model;

import javafx.scene.image.Image;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Card {
    private Faction faction;
    private String name;
    private String cardKind;
    private boolean hero;
    private Location location;
    private String ability;
    private int count;
    private int remainCount;
    private String power;
    private BufferedImage image;

    public static ArrayList<String> cardsName= new ArrayList<>();
    public static HashMap<String, String> cardAbility= new HashMap<>();


    public Card(Faction faction, BufferedImage image) {
        this.faction = faction;
        this.image = image;
    }

    public Faction getFaction() {
        return faction;
    }

    public String getName() {
        return name;
    }

    public String getCardKind() {
        return cardKind;
    }

    public boolean getHero() {
        return hero;
    }

    public Location getLocation() {
        return location;
    }

    public String getAbility() {
        return ability;
    }

    public int getCount() {
        return count;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public String getPower() {
        return power;
    }

    public BufferedImage getImage() {
        return image;
    }
}

