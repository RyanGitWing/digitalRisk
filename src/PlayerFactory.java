import java.util.List;
import java.util.Map;
/**
 * Creates players and assigns countries and armies.
 *
 * Author: Fareen. L
 * Version: 10.23.2020
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

    public void CreatePlayers(int playerCount) {
        List<Player> players = null;
        int armyCount = ARMY_COUNTS.get(playerCount);
        //todo: use Map class to instantiate maps
        for (int i = 0; i < playerCount; i++){
            players.add(new Player("Player " + i, null));
        }
    }
}
