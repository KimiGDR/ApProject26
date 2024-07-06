package Controller;

import Model.Card;
import Model.Faction;
import Model.User;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.CardsPage;
import view.PreGame;
import view.PreGameMenu;

import java.util.Objects;

public class PreGameController {

    public Pane pane;
    public TextField friendName;
    public Button selectFaction, selectLeader;
    public ImageView blueImage, yellowImage, redImage, greenImage, purpleImage;
    public Label pageLabel, blueLabel, yellowLabel, redLabel, greenLabel, purpleLabel;
    private String factionId = null;
    public ImageView leader1, leader2, leader3, leader4, leader5;
    private String leaderId = null;

    //Check again
    public void checkName(MouseEvent mouseEvent) {
        if (Objects.equals(friendName.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Empty box!");
            alert.setContentText("You cannot play with nobody!");
            alert.show();
        }
//        else if (Objects.equals(friendName.getText(), user.nickName)) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("WARNING");
//            alert.setHeaderText("Wrong ID!");
//            alert.setContentText("You cannot play with you!");
//            alert.show();
//        }
        else {
            PreGame preGame = new PreGame();
            try {
                preGame.start(PreGameMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showFactions() {
        blueImage.setFitWidth(95);
        blueImage.setFitHeight(150);
        yellowImage.setFitWidth(95);
        yellowImage.setFitHeight(150);
        redImage.setFitWidth(95);
        redImage.setFitHeight(150);
        greenImage.setFitWidth(95);
        greenImage.setFitHeight(150);
        purpleImage.setFitWidth(95);
        purpleImage.setFitHeight(150);
        blueLabel.setVisible(false);
        yellowLabel.setVisible(false);
        redLabel.setVisible(false);
        greenLabel.setVisible(false);
        purpleLabel.setVisible(false);

    }

    public void leadersNormalSize() {
        leader1.setFitWidth(95);
        leader1.setFitHeight(150);
        leader2.setFitWidth(95);
        leader2.setFitHeight(150);
        leader3.setFitWidth(95);
        leader3.setFitHeight(150);
        leader4.setFitWidth(95);
        leader4.setFitHeight(150);
        leader5.setFitWidth(95);
        leader5.setFitHeight(150);
    }

    public void makeBig(ImageView imageView) {
        imageView.setFitWidth(150);
        imageView.setFitHeight(200);
    }

    public void selectFaction(MouseEvent mouseEvent) {
        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();
        if (clickedNode != null) {
            factionId = clickedNode.getId();
        }
        Card.cardsName.clear();
        showFactions();
        pageLabel.setText("Choose your Faction");
        freeLeaderPlaces();
        selectLeader.setVisible(false);

        switch (factionId) {
            case "blueImage":
                makeBig(blueImage);
                blueLabel.setVisible(true);
                selectFaction.setOnMouseClicked(event -> showLeader("blue"));
                break;
            case "yellowImage":
                makeBig(yellowImage);
                yellowLabel.setVisible(true);
                selectFaction.setOnMouseClicked(event -> showLeader("yellow"));
                break;
            case "redImage":
                makeBig(redImage);
                redLabel.setVisible(true);
                selectFaction.setOnMouseClicked(event -> showLeader("red"));
                break;
            case "greenImage":
                makeBig(greenImage);
                greenLabel.setVisible(true);
                selectFaction.setOnMouseClicked(event -> showLeader("green"));
                break;
            case "purpleImage":
                makeBig(purpleImage);
                purpleLabel.setVisible(true);
                selectFaction.setOnMouseClicked(event -> showLeader("purple"));
                break;
        }
    }

    public void freeLeaderPlaces() {
        leader1.setImage(null);
        leader2.setImage(null);
        leader3.setImage(null);
        leader4.setImage(null);
        leader5.setImage(null);
    }

    public void goChooseCards(String leader) {
        User.nameOfLeader = leader;
        CardsPage cardsPage = new CardsPage();
        try {
            cardsPage.start(PreGame.stage);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void showLeader(String factionColor) {
        User.colorOfFaction = factionColor;
        pageLabel.setText("Choose your Leader");
        selectLeader.setVisible(true);
        Faction faction = new Faction(factionColor);

        switch (factionColor) {
            case "blue":
                faction.makeFactionCards("src/main/resources/photos/Northern Realms");
                leader1.setImage(new Image("/photos/blueLeaders/b1.png"));
                Card.cardsName.add("The Siegemaster");
                Card.cardAbility.put("The Siegemaster", "یک کارت impenetrable fog را از دسته کارت های شما انتخاب و بازی می شود" +
                        "(دقت شود اگر این کارت در دسته کارت های شما نبود نوبت به حریف می رسد و هیچ اتفاقی نمی افتد)");
                faction.makeFactionLeaders("photos/blueLeaders/b1.png", "The Siegemaster");

                leader2.setImage(new Image("/photos/blueLeaders/b2.png"));
                Card.cardsName.add("The Steel-Forged");
                Card.cardAbility.put("The Steel-Forged", "تاثیر آب و هوا را از بین می برد (تاثیر impenetrable fog, Biting Frost, Torrential Rain از بین می رود)");
                faction.makeFactionLeaders("/photos/blueLeaders/b2.png", "The Steel-Forged");

                leader3.setImage(new Image("/photos/blueLeaders/b3.png"));
                Card.cardsName.add("King of Temeria");
                Card.cardAbility.put("King of Temeria", "قدرت کارت های siege دو برابر می شود مگر این که یک کارت Commander's Horn در آن ردیف باشد");
                faction.makeFactionLeaders("/photos/blueLeaders/b3.png", "King of Temeria");

                leader4.setImage(new Image("/photos/blueLeaders/b4.png"));
                Card.cardsName.add("Lord Commander of the North");
                Card.cardAbility.put("Lord Commander of the North", "اگر قدرت کارت های siege بازیکن مقابل بیشتر از 10 باشد قویترین کارت siege را نابود می کند");
                faction.makeFactionLeaders("/photos/blueLeaders/b4.png", "Lord Commander of the North");

                leader5.setImage(new Image("/photos/blueLeaders/b5.png"));
                Card.cardsName.add("Son of Medell");
                Card.cardAbility.put("Son of Medell", "اگر قدرت کارت های ranged بازیکن مقابل بیشتر از 10 باشد قویترین کارت ranged را نابود می کند");
                faction.makeFactionLeaders("/photos/blueLeaders/b5.png", "Son of Medell");
                break;

            case "yellow":
                faction.makeFactionCards("src/main/resources/photos/Nilfgaardian Empire");
                leader1.setImage(new Image("/photos/yellowLeaders/y1.png"));
                Card.cardsName.add("The White Flame");
                Card.cardAbility.put("The White Flame", "از دسته کارت های شما یک کارت Torrential Rain بر می دارد و بازی می شود");
                faction.makeFactionLeaders("/photos/yellowLeaders/y1.png", "The White Flame");

                leader2.setImage(new Image("/photos/yellowLeaders/y2.png"));
                Card.cardsName.add("His Imperial Majesty");
                Card.cardAbility.put("His Imperial Majesty", "سه کارت رندوم از دست حریف را می بینید");
                faction.makeFactionLeaders("/photos/yellowLeaders/y2.png", "His Imperial Majesty");

                leader3.setImage(new Image("/photos/yellowLeaders/y3.png"));
                Card.cardsName.add("Emperor of Nilfgaard");
                Card.cardAbility.put("Emperor of Nilfgaard", "قابلیت فرمانده حریف را کنسل می کند");
                faction.makeFactionLeaders("/photos/yellowLeaders/y3.png", "Emperor of Nilfgaard");

                leader4.setImage(new Image("/photos/yellowLeaders/y4.png"));
                Card.cardsName.add("The Relentless");
                Card.cardAbility.put("The Relentless", "یک کارت از دسته کارت های مرده حریف به انتخاب خود بردارید (دقت شود نمی توان کارت Hero برداشت)");
                faction.makeFactionLeaders("/photos/yellowLeaders/y4.png", "The Relentless");

                leader5.setImage(new Image("/photos/yellowLeaders/y5.png"));
                Card.cardsName.add("Invader of the North");
                Card.cardAbility.put("Invader of the North", "یک کارت از دسته کارت های مرده به صورت رندوم  هم برای خود بازیکن هم برای حریف آن به بازی برگردانده میشود ");
                faction.makeFactionLeaders("/photos/yellowLeaders/y5.png", "Invader of the North");
                break;

            case "red":
                faction.makeFactionCards("src/main/resources/photos/Monsters");
                leader1.setImage(new Image("/photos/redLeaders/r1.png"));
                Card.cardsName.add("Bringer of Death");
                Card.cardAbility.put("Bringer of Death", "قدرت کارت های colse combat دو برابر می شود مگر این که یک کارت Commander's Horn در آن ردیف باشد");
                faction.makeFactionLeaders("/photos/redLeaders/r1.png", "Bringer of Death");

                leader2.setImage(new Image("/photos/redLeaders/r2.png"));
                Card.cardsName.add("King of the wild Hunt");
                Card.cardAbility.put("King of the wild Hunt", "یک کارت از دسته کارت های مرده خود بردارید.دقت شود نمی توان کارت Hero برداشت");
                faction.makeFactionLeaders("/photos/redLeaders/r2.png", "King of the wild Hunt");

                leader3.setImage(new Image("/photos/redLeaders/r3.png"));
                Card.cardsName.add("Destroyer of Worlds");
                Card.cardAbility.put("Destroyer of Worlds", "دو کارت از کارت های قابل بازی خود را کشته و یک کارت جدید از میان دسته کارت های خود بردارید");
                faction.makeFactionLeaders("/photos/redLeaders/r3.png", "Destroyer of Worlds");

                leader4.setImage(new Image("/photos/redLeaders/r4.png"));
                Card.cardsName.add("Commander of the Red Riders");
                Card.cardAbility.put("Commander of the Red Riders", "یک کارت آب و هوا را از دسته خود انتخاب و آن را بازی کنید");
                faction.makeFactionLeaders("/photos/redLeaders/r4.png", "Commander of the Red Riders");

                leader5.setImage(new Image("/photos/redLeaders/r5.png"));
                Card.cardsName.add("The Treacherous");
                Card.cardAbility.put("The Treacherous", "قدرت کارت های spy هر دو طرف را دوبرابر می کند");
                faction.makeFactionLeaders("/photos/redLeaders/r5.png", "The Treacherous");
                break;

            case "green":
                faction.makeFactionCards("src/main/resources/photos/Scoia'tael");
                leader1.setImage(new Image("/photos/greenLeaders/g1.png"));
                Card.cardsName.add("Queen of Dol Blathanna");
                Card.cardAbility.put("Queen of Dol Blathanna", "اگر قدرت کارت های  Close Combat بازیکن مقابل بیشتر از 10 باشد قویترین کارت ranged را نابود می کند");
                faction.makeFactionLeaders("/photos/greenLeaders/g1.png", "Queen of Dol Blathanna");

                leader2.setImage(new Image("/photos/greenLeaders/g2.png"));
                Card.cardsName.add("The Beautiful");
                Card.cardAbility.put("The Beautiful", "قدرت کارت های Ranged combat دو برابر می شود مگر این که یک کارت Commander's Horn در آن ردیف باشد");
                faction.makeFactionLeaders("/photos/greenLeaders/g2.png", "The Beautiful");


                leader3.setImage(new Image("/photos/greenLeaders/g3.png"));
                Card.cardsName.add("Daisy of the Valley");
                Card.cardAbility.put("Daisy of the Valley", "در شروع بازی یک کارت اضافی به صورت رندوم به شما اختصاص داده میشود");
                faction.makeFactionLeaders("/photos/greenLeaders/g3.png", "Daisy of the Valley");

                leader4.setImage(new Image("/photos/greenLeaders/g4.png"));
                Card.cardsName.add("Pureblood Elf");
                Card.cardAbility.put("Pureblood Elf", "یک کارت Biting Frost را از دسته کارت های شما انتخاب و بازی می شود");
                faction.makeFactionLeaders("/photos/greenLeaders/g4.png", "Pureblood Elf");

                leader5.setImage(new Image("/photos/greenLeaders/g5.png"));
                Card.cardsName.add("Hope of the Aen Seidhe");
                Card.cardAbility.put("Hope of the Aen Seidhe", "کارت های agile unit را به سطری میبرد که قدرت آن ها بیشینه  شود" +
                        " (دقت شود کارت هایی که هم اکنون در سطری هستند که قدرت آن ها را بیشینه میکند جابجا نمیشوند )");
                faction.makeFactionLeaders("/photos/greenLeaders/g5.png", "Hope of the Aen Seidhe");
                break;

            case "purple":
                faction.makeFactionCards("src/main/resources/photos/Skellige");
                leader1.setImage(new Image("/photos/purpleLeaders/p1.png"));
                Card.cardsName.add("Crach an Craite");
                Card.cardAbility.put("Crach an Craite", "کارت های مرده بازیکنان را بر زده و به دسته کارت هایشان بر می گرداند");

                leader2.setImage(new Image("/photos/purpleLeaders/p2.png"));
                Card.cardsName.add("King Bran");
                Card.cardAbility.put("King Bran", "سرباز ها فقط نیمی از قدرتشان را تحت آب و هوا از دست می دهند");
                break;
        }
        faction.makeHeroes();
        faction.makeSpecials();
    }

    public void showLeaderInformation(ImageView imageView, String leaderName, String option) {
        ImageView copyImageView = new ImageView();
        copyImageView.setImage(imageView.getImage());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, option, ButtonType.OK);
        alert.setHeaderText(leaderName);
        alert.setGraphic(copyImageView);
        alert.show();
    }

    public void selectLeader(MouseEvent mouseEvent) {
        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();
        if (clickedNode != null) {
            leaderId = clickedNode.getId();
        }
        leadersNormalSize();
        switch (leaderId) {
            case "leader1":
                leader1.setFitWidth(150);
                leader1.setFitHeight(200);
                showLeaderInformation(leader1, Card.cardsName.get(0), Card.cardAbility.get(Card.cardsName.get(0)));
                selectLeader.setOnMouseClicked(event -> goChooseCards(Card.cardsName.get(0)));
                break;
            case "leader2":
                leader2.setFitWidth(150);
                leader2.setFitHeight(200);
                showLeaderInformation(leader2, Card.cardsName.get(1), Card.cardAbility.get(Card.cardsName.get(1)));
                selectLeader.setOnMouseClicked(event -> goChooseCards(Card.cardsName.get(1)));
                break;
            case "leader3":
                if (Card.cardsName.get(2) != null) {
                    leader3.setFitWidth(150);
                    leader3.setFitHeight(200);
                    showLeaderInformation(leader3, Card.cardsName.get(2), Card.cardAbility.get(Card.cardsName.get(2)));
                    selectLeader.setOnMouseClicked(event -> goChooseCards(Card.cardsName.get(2)));
                    break;
                }
            case "leader4":
                if (Card.cardsName.get(3) != null) {
                    leader4.setFitWidth(150);
                    leader4.setFitHeight(200);
                    showLeaderInformation(leader4, Card.cardsName.get(3), Card.cardAbility.get(Card.cardsName.get(3)));
                    selectLeader.setOnMouseClicked(event -> goChooseCards(Card.cardsName.get(3)));
                    break;
                }
            case "leader5":
                if (Card.cardsName.get(4) != null) {
                    leader5.setFitWidth(150);
                    leader5.setFitHeight(200);
                    showLeaderInformation(leader5, Card.cardsName.get(4), Card.cardAbility.get(Card.cardsName.get(4)));
                    selectLeader.setOnMouseClicked(event -> goChooseCards(Card.cardsName.get(4)));
                    break;
                }
        }
    }

    public void changeFriend(MouseEvent mouseEvent) {
        PreGameMenu preGameMenu = new PreGameMenu();
        try {
            preGameMenu.start(PreGame.stage);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void invalidFaction(MouseEvent mouseEvent) {
        if (factionId == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("No Faction chosen!");
            alert.setContentText("Choose a Faction!");
            alert.show();
        }
    }

    public void invalidLeader(MouseEvent mouseEvent) {
        if (leaderId == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("No Leader chosen!");
            alert.setContentText("Choose a Leader!");
            alert.show();
        }
    }
}
