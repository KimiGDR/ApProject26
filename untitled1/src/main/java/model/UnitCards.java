package model;

import java.util.Arrays;
import java.util.List;

public enum UnitCards {

    // Northern Realms Cards
    BALLISTA("Ballista", null, 6, false, 2, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    BLUE_STRIPES_COMMANDO("Blue Stripes Commando", Ability.TIGHT_BOND, 4, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    CATAPULT("Catapult", Ability.TIGHT_BOND, 8, false, 2, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    CRINFRID_REVERS_DRAGON_HUNTER("Crinfrid Reavers Dragon Hunter", Ability.TIGHT_BOND, 5, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    DETHMOLD("Dethmold", null, 6, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    DUN_BANNER_MEDIC("Dun Banner Medic", Ability.MEDIC, 5, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    ESTERAD_THYSSEN("Esterad Thyssen", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    JOHN_NATALIS("John Natalis", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    KAEDWENI_SIEGE_EXPERT("Kaedweni Siege Expert", Ability.MORALE_BOOST, 1, false, 3, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    KEIRA_METZ("Keira Metz", null, 5, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    PHILIPPA_EILHART("Philippa Eilhart", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    POOR_FUCKING_INFANTRY("Poor Fucking Infantry", Ability.TIGHT_BOND, 1, false, 4, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    PRINCE_STENNIS("Prince Stennis", Ability.SPY, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier", null, 1, false, 2, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    SABRINA_GLEVISSING("Sabrina Glevissing", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    SHELDON_SKAGGS("Sheldon Skaggs", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    SIEGE_TOWER("Siege Tower", null, 6, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    SIEGFRIED_OF_DENESLE("Siegfried of Denesle", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    SIGISMUND_DIJKSTRA("Sigismund Dijkstra", Ability.SPY, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    SILE_DE_TANSARVILLE("Síle de Tansarville", null, 5, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NORTHER_REALMS),
    THALER("Thaler", Ability.SPY, 1, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    TREBUCHET("Trebuchet", null, 6, false, 2, Arrays.asList(CardPlacement.SIEGE), Faction.NORTHER_REALMS),
    VERNON_ROCHE("Vernon Roche", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    VES("Ves", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),
    YARPEN_ZIRGRIN("Yarpen Zirgrin", null, 2, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NORTHER_REALMS),


    // Nilfgaard Cards
    ALBRICH("Albrich", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    ASSIRE_VAR_ANAHID("Assire var Anahid", null, 6, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    BLACK_INFANTRY_ARCHER("Black Infantry Archer", null, 10, false, 2, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    CAHIR_MAWR_DYFFRYN_AEP_CEALLACH("Cahir Mawr Dyffryn aep Ceallach", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    CYNTHIA("Cynthia", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    ETOLIAN_AUXILIARY_ARCHERS("Etolian Auxiliary Archers", Ability.MEDIC, 1, false, 2, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    FRINGILLA_VIGO("Fringilla Vigo", null, 6, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    HEAVY_ZERRIKANIAN_FIRE_SCORPION("Heavy Zerrikanian Fire Scorpion", null, 10, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard", Ability.TIGHT_BOND, 3, false, 4, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    LETHO_OF_GULET("Letho of Gulet", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    MENNO_COEHORN("Menno Coehoorn", Ability.MEDIC, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    MORVRAN_VOORHIS("Morvran Voorhis", null, 10, true, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),
    MORTEISEN("Morteisen", null, 3, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    NAUSICAA_CAVALRY_RIDER("Nausicaa Cavalry Rider", Ability.TIGHT_BOND, 2, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    PUTTKAMMER("Puttkammer", null, 3, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    RAINFARN("Rainfarn", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    RENUALD_AEP_MATSEN("Renuald aep Matsen", null, 5, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    ROTTEN_MANGONEL("Rotten Mangonel", null, 3, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),
    SHILARD_FITZ_OESTERLEN("Shilard Fitz-Oesterlen", Ability.SPY, 7, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    SIEGE_ENGINEER("Siege Engineer", null, 6, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),
    SIEGE_TECHNICIAN("Siege Technician", Ability.MEDIC, 0, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),
    STEFAN_SKELLEN("Stefan Skellen", Ability.SPY, 9, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    SWEERS("Sweers", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    TIBOR_EGGEBRACHT("Tibor Eggebracht", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    VANHEMAR("Vanhemar", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    VATTIER_DE_RIDEAUX("Vattier de Rideaux", Ability.SPY, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    VREEMDE("Vreemde", null, 2, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    YOUNG_EMISSARY("Young Emissary", Ability.TIGHT_BOND, 5, false, 2, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.NILFGAARDIEN_EMPIRE),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion", null, 5, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.NILFGAARDIEN_EMPIRE),


    // Monsters Cards
    ARACHAS_BEHEMOTH("Arachas Behemoth", Ability.MUSTER, 6, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.MONSTERS),
    ARACHAS("Arachas", Ability.MUSTER, 4, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    BOTCHLING("Botchling", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    CELAENO_HARPY("Celaeno Harpy", null, 2, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.MONSTERS),
    COCKATRICE("Cockatrice", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),
    CRONE_BREWESS("Crone: Brewess", Ability.MUSTER, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    CRONE_WEAVESS("Crone: Weavess", Ability.MUSTER, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    CRONE_WHISPESS("Crone: Whispess", Ability.MUSTER, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    DRAUG("Draug", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    EARTH_ELEMENTAL("Earth Elemental", null, 6, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.MONSTERS),
    ENDREGA("Endrega", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),
    FIEND("Fiend", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    FIRE_ELEMENTAL("Fire Elemental", null, 6, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.MONSTERS),
    FOGLET("Foglet", null, 2, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    FORKTAIL("Forktail", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    FRIGHTENER("Frightener", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    GARGOYLE("Gargoyle", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),
    GHOUL("Ghoul", Ability.MUSTER, 1, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    GRAVE_HAG("Grave Hag", null, 5, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),
    GRIFFIN("Griffin", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    HARPY("Harpy", null, 2, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.MONSTERS),
    ICE_GIANT("Ice Giant", null, 5, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.MONSTERS),
    IMLERITH("Imlerith", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    KAYRAN("Kayran", Ability.MORALE_BOOST, 8, true, 1, Arrays.asList(CardPlacement.AGILE), Faction.MONSTERS),
    LESHEN("Leshen", null, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    NEKKER("Nekker", Ability.MUSTER, 2, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    PLAGUE_MAIDEN("Plague Maiden", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    TOAD("Toad", Ability.SCORCH, 7, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),
    VAMPIRE_BRUXA("Vampire: Bruxa", Ability.MUSTER, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara", Ability.MUSTER, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    VAMPIRE_FLEDER("Vampire: Fleder", Ability.MUSTER, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    VAMPIRE_GARKAIN("Vampire: Garkain", Ability.MUSTER, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    VAMPIRE_KATAKAN("Vampire: Katakan", Ability.MUSTER, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    WEREWOLF("Werewolf", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.MONSTERS),
    WYVERN("Wyvern", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.MONSTERS),


    // Scoia'tael Cards
    BARCLAY_ELS("Barclay Els", null, 6, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),
    CIARAN_AEP_EASNILLIEN("Ciaran aep Easnillien", null, 3, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),
    DENNIS_CRANMER("Dennis Cranmer", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SCOIATAEL),
    DOL_BLATHANNA_ARCHER("Dol Blathanna Archer", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    DOL_BLATHANNA_SCOUT("Dol Blathanna Scout", null, 6, false, 3, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),
    DWARVEN_SKIRMISHER("Dwarven Skirmisher", Ability.MUSTER, 3, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SCOIATAEL),
    EITHNE("Eithne", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    ELVEN_SKIRMISHER("Elven Skirmisher", Ability.MUSTER, 2, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    FILAVANDREL("Filavandrel", null, 6, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),
    HAVEKAR_HEALER("Havekar Healer", Ability.MEDIC, 0, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    HAVEKAR_SMUGGLER("Havekar Smuggler", Ability.MUSTER, 5, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SCOIATAEL),
    IDA_EMEAN_AEP_SIVNEY("Ida Emean aep Sivney", null, 6, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    IORVETH("Iorveth", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    ISENGRIM_FAOILTIARNA("Isengrim Faoiltiarna", Ability.MORALE_BOOST, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SCOIATAEL),
    MAHAKAMAN_DEFENDER("Mahakaman Defender", null, 5, false, 5, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SCOIATAEL),
    MILVA("Milva", Ability.MORALE_BOOST, 10, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    RIORDAIN("Riordain", null, 1, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    SEASENTHESSIS("Seasenthessis", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    SCHIRRU("Schirru", Ability.SCORCH, 8, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.SCOIATAEL),
    TORUVIEL("Toruviel", null, 2, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    VRIHEDD_BRIGADE_RECRUIT("Vrihedd Brigade Recruit", null, 4, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SCOIATAEL),
    VRIHEDD_BRIGADE_VETERAN("Vrihedd Brigade Veteran", null, 5, false, 2, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),
    YAEVINN("Yaevinn", null, 6, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.SCOIATAEL),


    // Skellige
    BERSERKER("Berserker", Ability.BERSERKER, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    BIRNA("Birna", Ability.MEDIC, 2, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    BLUEBOY("Blueboy", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    BROKVAR_ARCHER("Brokvar Archer", null, 6, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    CERYS("Cerys", Ability.MUSTER, 10, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    CRAITE_WARRIOR("Craite Warrior", Ability.TIGHT_BOND, 6, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    DIMUN_PIRATE("Dimun Pirate", Ability.SCORCH, 6, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    DONAR("Donar", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    DRAIG("Draig", Ability.COMMANDERS_HORN, 2, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.SKELLIGE),
    ERMION("Ermion", Ability.MARDROEME, 8, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    HEMDALL("Hemdall", Ability.TIGHT_BOND, 11, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    HEYMAEY("Heymaey", Ability.TIGHT_BOND, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    HJALMAR("Hjalmar", null, 10, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    HOLGER("Holger", null, 4, false, 1, Arrays.asList(CardPlacement.SIEGE), Faction.SKELLIGE),
    KAMBI("Kambi", Ability.TRANSFORMER, 11, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    LIGHT_LONGSHIP("Light Longship", Ability.MUSTER, 4, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    MADMAN_LUGOS("Madman Lugos", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    OLAF("Olaf", Ability.MORALE_BOOST, 12, false, 1, Arrays.asList(CardPlacement.AGILE), Faction.SKELLIGE),
    SHIELDMAIDEN("Shieldmaiden", Ability.TIGHT_BOND, 4, false, 3, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    SVANRIGE("Svanrige", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    TORDARROCH("Tordarroch", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    UDALRYK("Udalryk", null, 4, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    VILDKAARL("Vildkaarl", Ability.MORALE_BOOST, 14, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), Faction.SKELLIGE),
    WAR_LONGSHIP("War Longship", Ability.TIGHT_BOND, 6, false, 3, Arrays.asList(CardPlacement.SIEGE), Faction.SKELLIGE),
    YOUNG_BERSERKER("Young Berserker", Ability.BERSERKER, 2, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
    YOUNG_VIDKAARL("Young Vidkaarl", Ability.TIGHT_BOND, 8, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), Faction.SKELLIGE),
//    MARDROEME("Mardroeme", Ability.MARDROEME, 0, false, 3,Arrays.asList(CardPlacement.SPECIAL_SLOT, CardPlacement.SPELL)),


    // Neutral Cards
    BITING_FROST("Biting Frost", null, 0, true, 3, Arrays.asList(CardPlacement.WEATHER), null),
    CLEAR_WEATHER("Clear Weather", null, 0, true, 3, Arrays.asList(CardPlacement.WEATHER), null),
    COMMANDERS_HORN("Commander's horn", Ability.COMMANDERS_HORN, 0, true, 3, Arrays.asList(CardPlacement.SPELL), null),
    DECOY("Decoy", Ability.DECOY, 0, true, 3, Arrays.asList(CardPlacement.SPELL), null),
    IMPENETRABLE_FOG("Impenetrable fog", null, 0, true, 3, Arrays.asList(CardPlacement.WEATHER), null),
    SCORCH("Scorch", Ability.SCORCH, 0, true, 3, Arrays.asList(CardPlacement.SPELL), null),
    TORRENTIAL_RAIN("Torrential Rain", null, 0, true, 3, Arrays.asList(CardPlacement.WEATHER), null),


    //???
    SKELLIGE_STORM("Skellige Storm", null, 0, true, 3, Arrays.asList(CardPlacement.WEATHER), null),
    DANDELION("Dandelion", Ability.COMMANDERS_HORN, 2, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    COW("Cow", Ability.TRANSFORMER, 0, false, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), null),
    EMIEL_REGIS("Emiel Regis", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    GAUNTER_ODIMM("Gaunter O’Dimm", Ability.MUSTER, 2, false, 1, Arrays.asList(CardPlacement.SIEGE), null),
    GAUNTER_ODIMM_DARKNESS("Gaunter O’DImm Darkness", Ability.MUSTER, 4, false, 3, Arrays.asList(CardPlacement.RANGED_COMBAT), null),
    GERALT_OF_RIVIA("Geralt of Rivia", null, 15, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    MYSTERIOUS_ELF("Mysterious Elf", Ability.SPY, 0, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    OLGIERD_VON_EVEREC("Olgierd Von Everec", Ability.MORALE_BOOST, 6, false, 1, Arrays.asList(CardPlacement.AGILE), null),
    TRISS_MERIGOLD("Triss Merigold", null, 7, true, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    VESEMIR("Vesemir", null, 6, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    VILLENTRETENMERTH("Villentretenmerth", Ability.SCORCH, 7, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null),
    YENNEFER_OF_VENGERBERG("Yennefer of Vengerberg", Ability.MEDIC, 7, true, 1, Arrays.asList(CardPlacement.RANGED_COMBAT), null),
    ZOLTAN_CHIVAY("Zoltan Chivay", null, 5, false, 1, Arrays.asList(CardPlacement.CLOSE_COMBAT), null);

    private final String name;
    private final Ability ability;
    private final int power;
    private final boolean isHero;
    private final int numberOfCardsInGame;
    private final List<CardPlacement> playingRows;
    private final Faction faction;

    UnitCards(String name, Ability ability, int power, boolean isHero, int numberOfCardsInGame, List<CardPlacement> playingRows, Faction faction) {
        this.name = name;
        this.ability = ability;
        this.power = power;
        this.isHero = isHero;
        this.numberOfCardsInGame = numberOfCardsInGame;
        this.playingRows = playingRows;
        this.faction = faction;
    }

    public String getName() {
        return name;
    }

    public Ability getAbility() {
        return ability;
    }

    public int getPower() {
        return power;
    }

    public boolean isHero() {
        return isHero;
    }

    public int getNumberOfCardsInGame() {
        return numberOfCardsInGame;
    }

    public List<CardPlacement> getPlayingRows() {
        return playingRows;
    }

    public Faction getFaction() {
        return faction;
    }

    public String getImagePath() {
        return "/photos/allCards/" + this.name + ".png";
    }

}
