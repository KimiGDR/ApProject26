package controller;

import model.Ability;
import model.UnitCards;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Card;
import model.PlayerSet;
import model.Row;

import java.util.ArrayList;

public class GameController {
    public void decoyAbility(ArrayList<Card> cards, Row deck) {

    }

    public void medicAbility(ArrayList<Card> discardPile, Pane pane) {
        HBox discardPileHbox = new HBox();
        for (Card card : discardPile) {
            discardPileHbox.getChildren().add(card);
        }
        pane.getChildren().add(discardPileHbox);
    }

    public void moralBoostAbility(Card card, Row row, PlayerSet playerSet) {
        for (Card otherCard : row.getCards()) {
            if (!otherCard.equals(card))
                otherCard.setPower(otherCard.getPower() + 1);
        }
        row.updateScore();
        playerSet.setTotalPoints();
    }


    public void musterAbility(Card card, Row deck, ArrayList<Card> hand) {
        for (Card otherCard : deck.getCards()) {
            if (!otherCard.equals(card) && otherCard.getUnitCard().equals(card.getUnitCard())) {
                card.getRow().addCardToRow(otherCard);
                otherCard.setPlaying(true);
            }
        }
        for (Card otherCard : hand) {
            if (!otherCard.equals(card) && otherCard.getUnitCard().equals(card.getUnitCard())) {
                card.getRow().addCardToRow(otherCard);
                otherCard.setPlaying(true);
            }
        }
    }


    public void tightBond(PlayerSet playerSet, Card card) {
        int count = 0;
        ArrayList<Card> sameCards = new ArrayList<>();
        for (Card otherCard : card.getRow().getCards()) {
            if (otherCard.getUnitCard().getPower() == card.getUnitCard().getPower() &&
                    otherCard.getUnitCard().getAbility().equals(Ability.TIGHT_BOND)) {
                count++;
                sameCards.add(otherCard);
            }
        }

        for (Card card1 : sameCards) {
            card1.setPower(count * card1.getPower());
        }

        card.getRow().updateScore();
        playerSet.setTotalPoints();
    }

    public void commandersHornAbility(PlayerSet playerSet, Card card) {
        for (Card card1 : card.getRow().getCards()) {
            card1.setPower(2 * card1.getPower());
        }

        card.getRow().updateScore();
        playerSet.setTotalPoints();

    }

    public void scorchAbility(Card card, PlayerSet rivalPlayerSet, PlayerSet playerSet) {
        int maxPower = 0;
        Card maxPowerCard = card;
        if (!card.getUnitCard().getName().equals("Scorch")) {
//            boolean isMostPowerInRivalSet = true;
//
//            for (Card card1 : rivalPlayerSet.getAllCardsPlaying()) {
//                if (card1.getPower() > maxPower && !card1.equals(card)) {
//                    maxPower = card1.getPower();
//                    maxPowerCard = card1;
//                }
//            }
            for (Card card1 : playerSet.getAllCardsPlaying()) {
                if (card1.getPower() > maxPower && !card1.equals(card)) {
                    maxPower = card1.getPower();
                    maxPowerCard = card1;
                    System.out.println(maxPowerCard.getUnitCard().getName());
//                    isMostPowerInRivalSet = false;
                }
            }
//            if (isMostPowerInRivalSet) {
//                addCardToDiscardPile(maxPowerCard, rivalPlayerSet);
//            } else {
            addCardToDiscardPile(maxPowerCard, playerSet);
//            }
        }
    }


    private void addCardToDiscardPile(Card card, PlayerSet playerSet) {
        playerSet.getDiscardPile().add(card);
        playerSet.getAllCardsPlaying().remove(card);
        card.getRow().removeCard(card);
        playerSet.setTotalPoints();
        card.setInDiscardPile(true);
        card.setPlaying(false);
    }


    public void mardroemeAbility(Card card, PlayerSet playerSet) {
        for (Card otherCard : card.getRow().getCards()) {
            if (!otherCard.equals(card) && otherCard.getUnitCard().getAbility().equals(Ability.BERSERKER)) {
                transform(otherCard, UnitCards.VILDKAARL, playerSet);
            }
        }
    }


    private void transform(Card card, UnitCards unitCard, PlayerSet playerSet) {
        card.initializeCard(unitCard);
        card.getRow().updateScore();
        playerSet.setTotalPoints();
    }
}
