package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
    public static ArrayList <String> leadersName = new ArrayList<>();
    public static ArrayList<UnitCards> cardsOfFaction= new ArrayList<>();
    public static HashMap<String, String> cardAbility= new HashMap<>();

    private String name;
    private Ability ability;
    private int power;
    private int numberOfCardsInGame;
    private List<CardPlacement> playingRows;
    private Faction faction;
    Card(String name, Ability ability, int power, int numberOfCardsInGame, List<CardPlacement> playingRows, Faction faction) {
        this.name = name;
        this.ability = ability;
        this.power = power;
        this.numberOfCardsInGame = numberOfCardsInGame;
        this.playingRows = playingRows;
        this.faction = faction;
    }
}