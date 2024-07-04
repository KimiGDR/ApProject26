package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.scene.image.Image;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Faction {
    private String factionName;
    private String factionPower;
    private String leader;
    public static ArrayList<BufferedImage> cardsImage = new ArrayList<>();
    public static HashMap<String, Image> leadersName = new HashMap<>();


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
        cardsImage.clear();
        File dir = new File(directory);
        FilenameFilter pngFilter = (dir1, name) -> name.endsWith(".png");
        File[] pngFiles = dir.listFiles(pngFilter);

        if (pngFiles != null) {
            for (File file : pngFiles) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    cardsImage.add(image);
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
}
