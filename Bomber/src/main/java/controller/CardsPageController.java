package controller;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Faction;
import model.User;
import 
import view.CardsPage;
import view.PreGame;
import java.net.URL;
import java.util.ResourceBundle;

public class CardsPageController implements Initializable {

    public Pane pane;
    public Label leader, northernRealms, nilfgaardianEmpire, monsters, scoiatael, skellige;
    public ScrollPane availableCards, deckCardsScroll;
    public ImageView leaderPhoto;
    public VBox deckCards, remainCards;
    public Label unitCardCounter, spacialCardsCounter, heroCounter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deckCardsScroll.setPrefViewportWidth(309);
        switch (User.colorOfFaction) {
            case "blue":
                northernRealms.setVisible(true);
                break;
            case "yellow":
                nilfgaardianEmpire.setVisible(true);
                break;
            case "red":
                monsters.setVisible(true);
                break;
            case "green":
                scoiatael.setVisible(true);
                break;
            case "purple":
                skellige.setVisible(true);
                break;
        }
        leader.setText(User.nameOfLeader);
        leaderPhoto.setImage(Faction.leadersName.get(User.nameOfLeader));
        showCards();
    }

    public void findFactionName(MouseEvent mouseEvent) {
        switch (User.colorOfFaction) {
            case "blue":
                showFactionInformationAlert("/photos/Norther-Realms(blue).png", "Northern Realms", "Draw a card from your deck whenever you win a round.");
                break;
            case "yellow":
                showFactionInformationAlert("/photos/Nilfgaardian-Empire(yellow).png", "Nilfgaardian Empire", "Wins any round that ends in a draw.");
                break;
            case "red":
                showFactionInformationAlert("/photos/Monsters(red).png", "Monsters", "Keeps a random Unit Card out after each round.");
                break;
            case "green":
                showFactionInformationAlert("/photos/Scoia'tael(green).png", "Scoia'tael", "Decides who takes first turn.");
                break;
            case "purple":
                showFactionInformationAlert("/photos/Skellige(purple).png", "Skellige", "2 random cards from the graveyard are placed on the battled at the start of the third round.");
                break;
        }
    }

    public void showFactionInformationAlert(String address, String header, String option) {
        Image image = new Image(getClass().getResource(address).toExternalForm());
        ImageView imageView = new ImageView(image);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, option, ButtonType.OK);
        alert.setHeaderText(header);
        alert.setGraphic(imageView);
        alert.showAndWait();
    }

    public void goFactionPage(MouseEvent mouseEvent) {
        PreGame preGame = new PreGame();
        try {
            preGame.start(CardsPage.stage);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void showCards() {
        remainCards.setSpacing(10);

        for (int i = 0; i < (Faction.unitCardsImage.size() + Faction.heroCards.size() + Faction.specialCards.size()) / 3 + 1; i++) {
            HBox hbox = new HBox();
            hbox.setSpacing(3);
            for (int j = 3 * i; j < 3 * i + 3 && j < Faction.unitCardsImage.size() + Faction.heroCards.size() + Faction.specialCards.size(); j++) {
                ImageView imageView = null;
                if (j < Faction.unitCardsImage.size()) {
                    imageView = new ImageView(SwingFXUtils.toFXImage(Faction.unitCardsImage.get(j), null));
                } else if (j < Faction.unitCardsImage.size() + Faction.heroCards.size()) {
                    imageView = new ImageView(SwingFXUtils.toFXImage(Faction.heroCards.get(j - Faction.unitCardsImage.size()), null));
                } else if (j >= Faction.unitCardsImage.size() + Faction.heroCards.size() && j < Faction.unitCardsImage.size() + Faction.heroCards.size() + Faction.specialCards.size()) {
                    imageView = new ImageView(SwingFXUtils.toFXImage(Faction.specialCards.get(j - Faction.unitCardsImage.size() - Faction.heroCards.size()), null));
                }
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);
                hbox.getChildren().add(imageView);
                imageView.setOnMouseClicked(event -> addToDeck());
            }
            remainCards.getChildren().add(hbox);
        }

        availableCards.setContent(remainCards);
        availableCards.setPrefViewportWidth(309);
        availableCards.setFitToWidth(true);
    }

    public void showRemainCards() {

    }

    public void returnCardsToDeckCards() {

    }

    public void addToDeck() {
        for (Node hboxNode : remainCards.getChildren()) {
            if (hboxNode instanceof HBox) {
                HBox remainHbox = (HBox) hboxNode;
                HBox newHBox = new HBox();
                for (Node imageViewNode : remainHbox.getChildren()) {
                    if (imageViewNode instanceof ImageView) {
                        ImageView imageView = (ImageView) imageViewNode;
                        imageView.setOnMouseClicked(event -> {
                            ImageView newImageView = new ImageView(imageView.getImage());
                            newImageView.setPreserveRatio(imageView.isPreserveRatio());
                            newImageView.setFitWidth(100);
                            newImageView.setFitHeight(150);
                            deckCards.getChildren().add(newImageView);
                            newImageView.setOnMouseClicked(newEvent -> deleteFromDeck());
                            remainHbox.getChildren().remove(imageView);
                            newHBox.getChildren().add(newImageView);

                            if (!deckCards.getChildren().contains(newHBox) && !newHBox.getChildren().isEmpty()) {
                                deckCards.getChildren().add(newHBox);
                            }
                        });
                    }
                }
            }
        }
    }

    public void deleteFromDeck() {
        for (Node hboxNode : deckCards.getChildren()) {
            if (hboxNode instanceof HBox) {
                HBox deckHbox = (HBox) hboxNode;
                for (Node imageViewNode : deckHbox.getChildren()) {
                    if (imageViewNode instanceof ImageView) {
                        ImageView imageView = (ImageView) imageViewNode;
                        imageView.setOnMouseClicked(event -> {
                            ImageView newImageView = new ImageView(imageView.getImage());
                            newImageView.setFitWidth(imageView.getFitWidth());
                            newImageView.setFitHeight(imageView.getFitHeight());
                            newImageView.setPreserveRatio(imageView.isPreserveRatio());

                            findHBoxWithLessThanThreeImages(imageView);
                            imageView.setOnMouseClicked(newEvent -> addToDeck());

                            deckHbox.getChildren().remove(imageView);
                        });
                    }
                }
            }
        }
    }

    private void findHBoxWithLessThanThreeImages(ImageView imageView) {
        for (int i = remainCards.getChildren().size() - 1; i >= 0; i--) {
            if (remainCards.getChildren().get(i) instanceof HBox) {
                HBox hbox = (HBox) remainCards.getChildren().get(i);
                if (hbox.getChildren().stream().filter(child -> child instanceof ImageView).count() < 3) {
                    hbox.getChildren().add(imageView);
                }
            }
        }
    }

    public void showDeck() {

    }

    public void checkDeckCards(MouseEvent mouseEvent) {
        int countOfUnitCardsInDeck = 0;
        for (Node hboxNode : deckCards.getChildren()) {
            if (hboxNode instanceof HBox) {
                HBox deckHbox = (HBox) hboxNode;
                for (Node imageViewNode : deckHbox.getChildren()) {
                    if (imageViewNode instanceof ImageView) {

                    }
                }
            }
        }
        System.out.println(countOfUnitCardsInDeck);
        if (countOfUnitCardsInDeck < 22) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Low Cards!");
            alert.setContentText("You should choose at least 22 Unit Cards.");
            alert.show();
        }
    }

    public String incrementCounter(int counter) {
        counter++;
        return String.valueOf(counter);
    }

    public String decrementCounter(int counter) {
        if (counter > 0) {
            counter--;
        }
        return String.valueOf(counter);
    }

    private void showSaveAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Save Deck");
        alert.setContentText("Do you want to save your deck?");

        ButtonType saveDeck = new ButtonType("yes");
        ButtonType dontSaveDeck = new ButtonType("no");

        alert.getButtonTypes().setAll(saveDeck, dontSaveDeck);

        alert.showAndWait().ifPresent(response -> {
            if (response == saveDeck) {
                System.out.println("عملیات تایید شد.");
            } else if (response == dontSaveDeck) {
                System.out.println("عملیات لغو شد.");
            }
        });
    }
}
