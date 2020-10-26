import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Creates players and assigns countries and armies.
 *
 * @author Fareen. L
 * @version 10.25.2020
 */
public class PlayerFactory {

    private static final Map<Integer, Integer> ARMY_COUNTS = null;

    public PlayerFactory() {
        ARMY_COUNTS.put(2, 50);
        ARMY_COUNTS.put(3, 35);
        ARMY_COUNTS.put(4, 30);
        ARMY_COUNTS.put(5, 25);
        ARMY_COUNTS.put(6, 20);
    }

    /**
     * Creates and sets up the players.
     *
     * @param playerCount The number of players playing the game.
     */
    public void CreatePlayers(int playerCount) {
        List<Player> players = null;
        int armyCount = ARMY_COUNTS.get(playerCount);
        for (int i = 0; i < playerCount; i++){
            players.add(new Player("Player" + (i + 1), GetPlayerMap(i, armyCount)));
        }
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

        switch (i) {
            case 1:
                pM.put(new Country(CountryName.Congo), armyCount);
            case 2:
                pM.put(new Country(CountryName.EastAfrica), armyCount);
            case 3:
                pM.put(new Country(CountryName.NorthAfrica), armyCount);
            case 4:
                pM.put(new Country(CountryName.SouthAfrica), armyCount);
            case 5:
                pM.put(new Country(CountryName.Egypt), armyCount);
            case 6:
                pM.put(new Country(CountryName.Madagascar), armyCount);
        }
        return pM;
    }
}