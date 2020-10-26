import java.util.Map;

/**
 * Represents the player's object and moves.
 *
 * @author Fareen. L
 * @version 10.25.2020
 */
public class Player {

    private final String NAME;
    private Map<Country, Integer> PlayerStatus;
    private boolean PlayerTurn;

    /**
     * Creates a new player object with initial country ownership and armies.
     *
     * @param name The name of the player.
     * @param starterSetup The starter map and army configuration of the player.
     */
    public Player(String name, Map<Country, Integer> starterSetup) {
        this.NAME = name;
        this.PlayerStatus = starterSetup;
        this.PlayerTurn = false;
    }

    /**
     * Prints out the player stats in the console.
     */
    public void GetStats() {
        System.out.println("Name: " + this.NAME + "/n Stats");
        for (Country country : PlayerStatus.keySet()) {
            // todo: write out countries and army counts.
        }
        System.out.println("Country count: " + GetCountryCount() + " Army count: " + GetArmyCount());
        String bool;
        if (PlayerTurn) bool = "Yes";
        else bool = "No";
        System.out.println("Turn: " + bool);
    }

    /**
     * Returns the army count in the specified country.
     *
     * @param country The country requesting the army count from.
     * @return The army count.
     */
    public int GetArmyCount(Country country) {
        return this.PlayerStatus.get(country);
    }

    /**
     * Returns the amount of countries the player holds.
     *
     * @return The total number of countries held by the player.
     */
    public int GetCountryCount() {
        return this.PlayerStatus.keySet().size();
    }

    /**
     * Returns the total army count of the player.
     *
     * @return The total army capacity held by the player.
     */
    public int GetArmyCount() {
        int count = 0;
        for (Country country : this.PlayerStatus.keySet()) {
            count += this.PlayerStatus.get(country);
        }
        return count;
    }

    /**
     * Returns the player's name if it is the player's turn.
     *
     * @return The player's name.
     */
    public String GetPlayerTurn() {
        if (PlayerTurn) return this.NAME;
        else return null;
    }

    /**
     * Method to roll the player's die and compare die results.
     *
     * @param target The target player.
     * @param source The player's attacking country.
     * @param enemy The player's target country.
     */
    public void PlayTurn(Player target, Country source, Country enemy) {
        // todo: roll die here
    }

    /**
     * Method to use if player won round. Moves attacking army to won country.
     *
     * @param source The country used by the player.
     * @param armyUsed The army capacity used.
     * @param target The take over country.
     */
    public void TurnWon(Country source, int armyUsed, Country target) {
        MoveArmy(source, armyUsed, target);
        PlayerTurn = false;
        // todo: next turn event
    }

    /**
     * Method to use if player lost round. Removes the country used from player's ownership.
     *
     * @param source The country used to play the turn.
     */
    public void TurnLost(Country source) {
        this.PlayerStatus.remove(source);
        PlayerTurn = false;
        // todo: next turn event
    }

    /**
     * Method to use if battle at standstill. Updates player's army numbers.
     *
     * @param source The country used to play the round.
     * @param armyLost Total amount of army lost during round.
     */
    public void TurnStagnant(Country source, int armyLost) {
        int newArmy = this.PlayerStatus.get(source) - armyLost;
        this.PlayerStatus.replace(source, newArmy);
    }

    /**
     *
     * @param source Player's source country.
     * @param armyCount Army lost at source country.
     * @param destination Player's destination country.
     */
    public void MoveArmy(Country source, int armyCount, Country destination) {
        //todo: make boolean
        //todo: implement path move
        if (PlayerTurn) {
            int newArmy = this.PlayerStatus.get(source) - armyCount;
            CountryCheck(newArmy, source);
            this.PlayerStatus.putIfAbsent(destination, newArmy);
            PlayerTurn = false;
        }
    }

    /**
     * Player name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return this.NAME;
    }

    /**
     *
     * @param armyCount The number of army men to remove.
     * @param country The country to remove from.
     */
    private void CountryCheck(int armyCount, Country country) {
        if (armyCount == 0) {
            // todo: check adjacent countries to see if owned by player
            this.PlayerStatus.remove(country);
        }
        this.PlayerStatus.replace(country, armyCount);
    }
}