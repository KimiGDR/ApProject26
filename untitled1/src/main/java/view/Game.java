package view;

import controller.GameController;
import model.UnitCards;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Card;
import model.PlayerSet;

public class Game extends Application {
    private Pane pane;
    private Stage stage;
    private GameController gameController;
    private PlayerSet firstPlayerSet;
    private PlayerSet secondPlayerSet;
    private PlayerSet currentPlayerSet;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        pane = new Pane();
        gameController = new GameController();
        setBackground();
        setStage();

        secondPlayerSet = new PlayerSet(null);  // Initialize second player set with null rival
        firstPlayerSet = new PlayerSet(secondPlayerSet);
        secondPlayerSet = new PlayerSet(firstPlayerSet);

        initializeRows();
        initializeDecks();

        firstPlayerSet.initializeTotalScore(false, pane);
        secondPlayerSet.initializeTotalScore(true, pane);

        currentPlayerSet = firstPlayerSet;
    }

    private void initializeDecks() {
        firstPlayerSet.addCardToDeck(new Card(UnitCards.MILVA, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.DUN_BANNER_MEDIC, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.KAEDWENI_SIEGE_EXPERT, firstPlayerSet));
        Card card = new Card(UnitCards.TOAD, firstPlayerSet);
        Card card1 = new Card(UnitCards.TOAD, firstPlayerSet);
        firstPlayerSet.getDiscardPile().add(card);
        firstPlayerSet.getDiscardPile().add(card1);
        firstPlayerSet.addCardToDeck(new Card(UnitCards.DWARVEN_SKIRMISHER, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.DWARVEN_SKIRMISHER, firstPlayerSet));
        firstPlayerSet.getHand().add(new Card(UnitCards.DWARVEN_SKIRMISHER, firstPlayerSet));
//        firstPlayerSet.addCardToDeck(new Card(UnitCards.MARDROEME, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.BERSERKER, firstPlayerSet));
        card.setInDiscardPile(true);
        card1.setInDiscardPile(true);
        firstPlayerSet.addCardToDeck(new Card(UnitCards.SCHIRRU, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.BLUE_STRIPES_COMMANDO, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.BLUE_STRIPES_COMMANDO, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.DANDELION, firstPlayerSet));
        firstPlayerSet.addCardToDeck(new Card(UnitCards.SCORCH, firstPlayerSet));
    }

    public void changeTurn() {
        currentPlayerSet = currentPlayerSet.getRival();
    }

    private void initializeRows() {
        firstPlayerSet.initializeRows(false, this.pane);
        secondPlayerSet.initializeRows(true, this.pane);
    }

    private void setStage() {
        stage.setScene(new Scene(pane));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
        pane.requestFocus();
    }

    private void setBackground() {
        Image image = new Image(Game.class.getResource("/photos/board.jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(image.getWidth() / 1.5);
        imageView.setFitHeight(image.getHeight() / 1.5);
        pane.getChildren().add(imageView);
    }
}
