import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player's object and moves.
 *
 * @author Fareen. L
 * @version 10.25.2020
 *
 * @version 11.08.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vyasan. J
 * @version 11.22.2020
 */
public class Player {

    private final String NAME;
    private List<Country> ownedCountries;
    private int totArmyCount;
    private boolean PlayerTurn;


    public Player(){
        NAME = "";
    }

    /**
     * Creates a new player object with initial country ownership and armies.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.NAME = name;
        this.ownedCountries = new ArrayList<>();
        this.totArmyCount = 0;
        this.PlayerTurn = false;
    }


    /**
     * Returns the total army count of the player.
     *
     * @return The total army capacity held by the player.
     */
    public int getArmyCount() {

        return this.totArmyCount;
    }

    public void setArmyCount(int newArmyCount) {

        totArmyCount = newArmyCount;
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
     * Returns the player's name if it is the player's turn.
     *
     * @return The player's name.
     */
    public String getPlayerTurn() {
        if (PlayerTurn) return this.NAME;
        else return null;
    }

    public List<Country> getOwnedCountries() {

        return ownedCountries;
    }

    public void addNewCountry(Country newCountry) {

        ownedCountries.add(newCountry);
    }

    @Override
    public String toString() {

        String playersInfo = "";
        playersInfo += this.getName() + " owns " + this.getOwnedCountries().size() + " countries and " + this.getArmyCount() + " armies.\n";
        return playersInfo;
    }

    /**
     * Prints the player status.
     */
    public void printPlayerStatus() {
        System.out.println(getName() + " owns " +
                getOwnedCountries().size() + " countries and "
                + getArmyCount() + " armies.");

        String ownedCountries = "";
        for (Country c : getOwnedCountries())
        {
            ownedCountries += c.getCountryName().name() + ": " + c.getArmyOccupied() + "\n";
        }
        System.out.println (ownedCountries);
    }

    public void removeNewCountry(Country newCountry) {
        ownedCountries.remove(newCountry);
    }

    public boolean isAI(){
        return false;
    }


}