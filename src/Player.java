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
 *
 * @author Fareen. L
 * @version 11.23.2020
 */
public class Player {

    private final String NAME;
    private List<Country> ownedCountries;
    private List<ContinentName> ownedContinents;
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

    /**
     * Sets the total army capacity held by the player.
     *
     * @param newArmyCount The army capacity to set.
     */
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

    /**
     * Returns the countries owned by the player.
     *
     * @return A list of owned countries.
     */
    public List<Country> getOwnedCountries() {

        return ownedCountries;
    }

    /**
     * Returns the continents owned by the player.
     *
     * @return A list of continent names.
     */
    public List<ContinentName> getOwnedContinents() {
        return ownedContinents;
    }

    /**
     * Adds a country to the player's owned countries.
     *
     * @param country The country object to be added.
     */
    public void addCountry(Country country) {
        ownedCountries.add(country);
        addContinent(country.getContinentName());
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

    /**
     * Removes a country from the player's owned countries.
     *
     * @param country The country to be removed.
     */
    public void removeCountry(Country country) {

        ownedCountries.remove(country);
        removeContinent(country.getContinentName());
    }

    /**
     * Checks to see if a player owns all countries in a continent.
     * If all countries are owned, adds the continent to the player's owned continents.
     *
     * @param name The name of the continent.
     * @return True if added, False otherwise.
     */
    private boolean addContinent(ContinentName name) {
        int defaultCountryCount = 0;
        int playerCountryCount = 0;

        switch (name) {
            case SouthAmerica:
                defaultCountryCount = 4;
            case NorthAmerica:
                defaultCountryCount = 9;
            case Australia:
                defaultCountryCount = 4;
            case Africa:
                defaultCountryCount = 6;
            case Europe:
                defaultCountryCount = 7;
            case Asia:
                defaultCountryCount = 12;
        }

        for (Country country : this.ownedCountries) {
            if (country.getContinentName().equals(name))  { playerCountryCount += 1; }
        }

        if (playerCountryCount == defaultCountryCount) {
            this.ownedContinents.add(name);
            return true;
        }

        return false;
    }

    /**
     * Removes a continent from the player's owned continents.
     *
     * @param name The continent name to remove.
     */
    private void removeContinent(ContinentName name) {
        this.ownedContinents.remove(name);
    }

    /**
     * Checks to see if a player is AI.
     *
     * @return False.
     */
    public boolean isAI(){
        return false;
    }


}