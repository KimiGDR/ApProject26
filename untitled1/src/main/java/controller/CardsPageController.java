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
import model.UnitCards;
import model.User;
import view.CardsPage;
import view.Game;
import view.PreGame;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CardsPageController implements Initializable {

    public Pane pane;
    public Label leader, northernRealms, nilfgaardianEmpire, monsters, scoiatael, skellige;
    public ScrollPane availableCards, deckCardsScroll;
    public ImageView leaderPhoto;
    public VBox deckCards, remainCards;
    public Label countOfUnitCards, countOfSpecialCards;

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
        Image image = new Image("/photos/leaders/" + User.nameOfLeader + ".png");
        leaderPhoto.setImage(image);
        showCards();
    }

    public void findFactionName(MouseEvent mouseEvent) {
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
                imageView.setId(Card.cardsOfFaction.get(j).getName());
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
                            newImageView.setId(imageView.getId());


                            newImageView.setFitWidth(100);
                            newImageView.setFitHeight(150);
                            deckCards.getChildren().add(newImageView);
                            newImageView.setOnMouseClicked(newEvent -> deleteFromDeck());
                            imageView.setImage(null);
                            newHBox.getChildren().add(newImageView);
                            for (UnitCards unitCard : Card.cardsOfFaction) {
                                if (Objects.equals(unitCard.getName(), imageView.getId())) {
                                    if (unitCard.getFaction() == null) {
                                        countOfSpecialCards.setText(Integer.toString(Integer.parseInt(countOfSpecialCards.getText()) + 1));
                                    } else {
                                        countOfUnitCards.setText(Integer.toString(Integer.parseInt(countOfUnitCards.getText()) + 1));
                                    }
                                    break;
                                }
                            }

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

                            for (Node destHboxNode : remainCards.getChildren()) {
                                if (destHboxNode instanceof HBox) {
                                    HBox remainHbox = (HBox) destHboxNode;
                                    for (Node newImageViewNode : remainHbox.getChildren()) {
                                        if (newImageViewNode instanceof ImageView) {
                                            ImageView newImageView = (ImageView) newImageViewNode;
                                            if (Objects.equals(newImageView.getId(), imageView.getId())) {
                                                for (UnitCards unitCard : Card.cardsOfFaction) {
                                                    if (Objects.equals(unitCard.getName(), imageView.getId())) {
                                                        if (unitCard.getFaction() == null) {
                                                            countOfSpecialCards.setText(Integer.toString(Integer.parseInt(countOfSpecialCards.getText()) - 1));
                                                        } else {
                                                            countOfUnitCards.setText(Integer.toString(Integer.parseInt(countOfUnitCards.getText()) - 1));
                                                        }
                                                        break;
                                                    }
                                                }
                                                newImageView.setImage(imageView.getImage());
                                                newImageView.setFitWidth(imageView.getFitWidth());
                                                newImageView.setFitHeight(imageView.getFitHeight());
                                                newImageView.setOnMouseClicked(newEvent -> addToDeck());
                                                deckHbox.getChildren().remove(imageView);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void showDeck() {
    }

    public void showAlertOfDeck(String kind) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        switch (kind) {
            case "unit":
                alert.setHeaderText("Too less unit cards");
                alert.setContentText("You can choose 22 or more unit cards");
                alert.showAndWait();
                break;
            case "special":
                alert.setHeaderText("Too much special cards");
                alert.setContentText("You can choose 10 or less special cards");
                alert.showAndWait();

        }
    }

    public void checkSave() {
        for (Node hboxNode : deckCards.getChildren()) {
            if (hboxNode instanceof HBox) {
                HBox deckHbox = (HBox) hboxNode;
                for (Node imageViewNode : deckHbox.getChildren()) {
                    if (imageViewNode instanceof ImageView) {
                        ImageView imageView = (ImageView) imageViewNode;
                        for (UnitCards unitCard : Card.cardsOfFaction) {
                            if (Objects.equals(imageView.getId(), unitCard.getName())) {
                                User.cardsInUse.add(unitCard);
                            }
                        }
                    }
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Saving");
        alert.setContentText("Do you want to save this deck ton use it in next plays?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            User.savedCards = User.cardsInUse;
        }
    }

    public void goToGame(MouseEvent mouseEvent) {
        if (Integer.parseInt(countOfUnitCards.getText()) < 22)
            showAlertOfDeck("unit");
        else if (Integer.parseInt(countOfSpecialCards.getText()) > 10)
            showAlertOfDeck("special");
        else {
            checkSave();
            Game game = new Game();
            try {
                game.start(CardsPage.stage);
            } catch (
                    Exception e) {
                e.printStackTrace();
            }
        }
    }
}
