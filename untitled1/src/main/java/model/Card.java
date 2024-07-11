package model;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import model.Ability;
import model.UnitCards;

import java.util.ArrayList;
import java.util.HashMap;

public class Card extends Node {
    public static ArrayList<String> leadersName = new ArrayList<>();
    public static ArrayList<UnitCards> cardsOfFaction= new ArrayList<>();
    public static HashMap<String, String> cardAbility= new HashMap<>();
    private String name;
    private int power;
    private boolean isPlaying;
    private boolean inDiscardPile;
    private Row row;
    private UnitCards UnitCards;
    private PlayerSet owner;

    public Card(UnitCards UnitCards, PlayerSet owner) {
        this.name = UnitCards.getName();
        this.power = UnitCards.getPower();
        this.UnitCards = UnitCards;
        this.isPlaying = false;
        this.inDiscardPile = false;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isInDiscardPile() {
        return inDiscardPile;
    }

    public void setInDiscardPile(boolean inDiscardPile) {
        this.inDiscardPile = inDiscardPile;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public UnitCards getUnitCard() {
        return UnitCards;
    }

    public PlayerSet getOwner() {
        return owner;
    }

    public void initializeCard(UnitCards UnitCards) {
        this.UnitCards = UnitCards;
        this.power = UnitCards.getPower();
    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }
}
