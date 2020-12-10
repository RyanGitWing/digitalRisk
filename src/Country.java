import java.io.Serializable;
import java.util.*;

/**
 * Represents a country.
 *
 * @author Vyasan. J
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 *
 * @author Fareen. L
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */
public class Country implements Serializable {

    private final String countryName;
    private final String continentName;
    private Player ruler;
    private int armyOccupied;
    private List<String> adjCountries;

    /**
     * Creates a new country object and sets up initial values.
     *
     * @param countryName The name of the country.
     */
    public Country(String countryName, String continentName){
        this.countryName = countryName;
        this.continentName = continentName;
        ruler = null;
        armyOccupied = 0;
        adjCountries = new ArrayList<>();
    }

    /**
     * Returns country's name.
     *
     * @return The name of the country.
     */
    public String getCountryName(){
        return this.countryName;
    }

    /**
     * Returns the name of the continent the country belongs to.
     *
     * @return A continent name.
     */
    public String getContinentName() { return this.continentName; }

    /**
     * Returns country's ruler.
     *
     * @return The ruler of the country
     */
    public Player getRuler(){
        return this.ruler;
    }

    /**
     * Sets the ruler of the country.
     *
     * @param ruler The ruler of the country.
     */
    public void setRuler(Player ruler){
        this.ruler = ruler;
    }

    /**
     * Returns the number of army occupying in country.
     *
     * @return The amount of army in country.
     */
    public int getArmyOccupied(){
        return this.armyOccupied;
    }

    /**
     * Sets the number of army occupying in the country.
     *
     * @param army The amount of army in the country.
     */
    public void setArmyOccupied(int army){
        armyOccupied = army;
    }

    /**
     * Returns adjacent countries.
     *
     * @return A list of adjacent countries
     */
    public List<String> getAdjCountries(){
        return adjCountries;
    }

    /**
     * Sets the countries adjacent to the current country
     *
     * @param adj The adjacent country
     */
    public void setAdjCountry(List<String> adj){
        adjCountries = adj;
    }
}