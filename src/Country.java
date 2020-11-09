import java.util.*;

/**
 * Represents the coutries
 *
 * @author: Vyasan. J
 * @version: 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 */
public class Country {

    private final CountryName name;
    private Player ruler;
    private int armyOccupied;
    private List<CountryName> adjCountries;

    /**
     * Creates a new country object and sets up initial values.
     *
     * @param name The name of the country.
     */
    public Country(CountryName name){
        this.name = name;
        ruler = null;
        armyOccupied = 0;
        adjCountries = new ArrayList<>();
    }

    /**
     * Returns country's name.
     *
     * @return The name of the country.
     */
    public CountryName getCountryName(){
        return this.name;
    }

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
    public List<CountryName> getAdjCountries(){
        return adjCountries;
    }

    /**
     * Sets the countries adjacent to the current country
     *
     * @param adj The adjacent country
     */
    public void setAdjCountry(List<CountryName> adj){
        adjCountries = adj;
    }
}