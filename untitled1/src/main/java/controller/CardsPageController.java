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
import model.Card;
import model.User;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deckCardsScroll.setPrefViewportWidth(309);
        switch (User.faction) {
            case NORTHER_REALMS:
                northernRealms.setVisible(true);
                break;
            case NILFGAARDIEN_EMPIRE:
                nilfgaardianEmpire.setVisible(true);
                break;
            case MONSTERS:
                monsters.setVisible(true);
                break;
            case SCOIATAEL:
                scoiatael.setVisible(true);
                break;
            case SKELLIGE:
                skellige.setVisible(true);
                break;
        }
        leader.setText(User.nameOfLeader);
//        leaderPhoto.setImage(Card.leadersName.get(User.nameOfLeader));
        showCards();
    }

    //check
    public void findFactionName(MouseEvent mouseEvent) {
        System.out.println(User.faction.name());
        switch (User.faction.name()) {
            case "NORTHER_REALMS":
                showFactionInformationAlert("/photos/factions/Norther-Realms(blue).png", "Northern Realms", "Draw a card from your deck whenever you win a round.");
                break;
            case "NILFGAARDIEN_EMPIRE":
                showFactionInformationAlert("/photos/factions/Nilfgaardian-Empire(yellow).png", "Nilfgaardian Empire", "Wins any round that ends in a draw.");
                break;
            case "MONSTERS":
                showFactionInformationAlert("/photos/factions/Monsters(red).png", "Monsters", "Keeps a random Unit Card out after each round.");
                break;
            case "SCOIATAEL":
                showFactionInformationAlert("/photos/factions/Scoia'tael(green).png", "Scoia'tael", "Decides who takes first turn.");
                break;
            case "SKELLIGE":
                showFactionInformationAlert("/photos/factions/Skellige(purple).png", "Skellige", "2 random cards from the graveyard are placed on the battled at the start of the third round.");
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

        for (int i = 0; i < Card.cardsOfFaction.size() / 3 + 1; i++) {
            HBox hbox = new HBox();
            hbox.setSpacing(3);
            for (int j = 3 * i; j < 3 * i + 3 && j < Card.cardsOfFaction.size(); j++) {
                ImageView imageView = new ImageView(Card.cardsOfFaction.get(j).getImagePath());
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

    public void goToGame(MouseEvent mouseEvent) {
        for (Node hboxNode : remainCards.getChildren()) {
            if (hboxNode instanceof HBox) {
                HBox remainHbox = (HBox) hboxNode;
                for (Node imageViewNode : remainHbox.getChildren()) {
                    if (imageViewNode instanceof ImageView) {

                    }
                }
            }
        }
    }
}
