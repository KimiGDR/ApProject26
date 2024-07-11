package model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PlayerSet {
    private ArrayList<Card> deck;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> hand;
    private ArrayList<Card> allCardsPlaying;
    private int totalPoints;
    private PlayerSet rival;

    public PlayerSet(PlayerSet rival) {
        this.deck = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.allCardsPlaying = new ArrayList<>();
        this.totalPoints = 0;
        this.rival = rival;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getAllCardsPlaying() {
        return allCardsPlaying;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints() {
        totalPoints = 0;
        for (Card card : allCardsPlaying) {
            totalPoints += card.getPower();
        }
    }

    public PlayerSet getRival() {
        return rival;
    }

    public void initializeRows(boolean isRival, Pane pane) {
        // Implementation of row initialization with reference to the pane.
        // This might involve setting up GUI components for each row.
    }

    public void initializeTotalScore(boolean isRival, Pane pane) {
        // Implementation of score initialization with reference to the pane.
        // This might involve setting up GUI components to display the score.
    }
}
