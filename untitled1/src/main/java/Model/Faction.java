package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Faction {
    private String factionName;
    private String factionPower;
    private String leader;
    public static ArrayList<BufferedImage> unitCardsImage = new ArrayList<>();
    public static ArrayList<BufferedImage> heroCards = new ArrayList<>();
    public static ArrayList<BufferedImage> specialCards = new ArrayList<>();
    public static HashMap<String, Image> leadersName = new HashMap<>();
    public static HashMap<ImageView, String> imageAddresses = new HashMap<>();


    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionName() {
        return factionName;
    }

    public String getFactionPower() {
        return factionPower;
    }

    public String getLeader() {
        return leader;
    }

    public void makeFactionCards(String directory) {
        unitCardsImage.clear();
        File dir = new File(directory);
        FilenameFilter filter = (dir1, name) -> name.endsWith(".png") || name.endsWith(".jpg");
        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    unitCardsImage.add(image);
                    ImageView imageView = new ImageView(SwingFXUtils.toFXImage(image, null));
                    imageAddresses.put(imageView, file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void makeFactionLeaders(String directory, String leaderName) {
        Image image = new Image(directory);
        leadersName.put(leaderName, image);
    }

    public void makeHeroes() {
        File dir = new File("src/main/resources/photos/Neutral Units");
        FilenameFilter filter = (dir1, name) -> name.endsWith(".png") || name.endsWith(".jpg");
        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    heroCards.add(image);
//                    imageAddresses.put(image, file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void makeSpecials() {
        File dir = new File("src/main/resources/photos/Neutrals");
        FilenameFilter filter = (dir1, name) -> name.endsWith(".png") || name.endsWith(".jpg");
        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    specialCards.add(image);
//                    imageAddresses.put(image, file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
