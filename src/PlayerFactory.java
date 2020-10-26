import java.util.*;

/**
 * Creates players and assigns countries and armies.
 *
 * Author: Fareen. L
 * Version: 10.25.2020
 *
 */
public class PlayerFactory {

    public PlayerFactory() {
    }

    /**
     * Creates and sets up the players.
     *
     * @param playerCount The number of players playing the game.
     * @return An array list of players.
     */
    public ArrayList<Player> CreatePlayers(int playerCount) {
        ArrayList<Player> players = new ArrayList<>(playerCount);
        int armyCount = getArmyCount(playerCount);
        for (int i = 1; i <= playerCount; i++){
            players.add(new Player("Player" + (i + 1), GetPlayerMap(i, armyCount)));
        }
        return players;
    }


    /**
     * Creates a HashMap of countries and assigned army men.
     *
     * @param i The player number.
     * @param armyCount The amount of army men.
     * @return The assigned army men and countries.
     */
    private static HashMap<Country, Integer> GetPlayerMap(int i, int armyCount) {
        HashMap<Country, Integer> pM = new HashMap<>();

        if (i == 1) pM.put(new Country(CountryName.Congo), armyCount);
        if (i == 2) pM.put(new Country(CountryName.EastAfrica), armyCount);
        if (i == 3) pM.put(new Country(CountryName.NorthAfrica), armyCount);
        if (i == 4) pM.put(new Country(CountryName.SouthAfrica), armyCount);
        if (i == 5) pM.put(new Country(CountryName.Egypt), armyCount);
        if (i == 6) pM.put(new Country(CountryName.Madagascar), armyCount);

        return pM;
    }

    /**
     * Returns army count based on number of players.
     *
     * @param playerCount The number of players playing.
     * @return The army capacity for each player.
     */
    private static int getArmyCount(int playerCount) {
        switch (playerCount) {
            case 2:
                return 50;
            case 3:
                return 35;
            case 4:
                return 30;
            case 5:
                return 25;
            case 6:
                return 20;
        }
        return -1;
    }
}