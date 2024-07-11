package model;

import java.util.ArrayList;

public class Row {
    private ArrayList<Card> cards;
    private int score;

    public Row() {
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCardToRow(Card card) {
        cards.add(card);
        card.setRow(this);
        updateScore();
    }

    public void removeCard(Card card) {
        cards.remove(card);
        updateScore();
    }

    public void updateScore() {
        score = 0;
        for (Card card : cards) {
            score += card.getPower();
        }
    }

    public int getScore() {
        return score;
    }
}
