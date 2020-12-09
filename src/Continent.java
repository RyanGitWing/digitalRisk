import java.util.*;

/**
 * Represents a continent.
 *
 * @author Vyasan.J
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 */
public class Continent {

    private ArrayList<Country> countries;
    private final String name;

    /**
     * Creates a new continent object.
     *
     * @param name The name of the continent.
     */
    public Continent(String name){
        this.name = name;
        countries = new ArrayList<>();
    }

    /**
     * Returns the name of the continent.
     *
     *@return The name of the continent.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the list of countries in the continent.
     *
     *@return The list of countries in the continent.
     */
    public List<Country> getCountries(){
        return this.countries;
    }

    /**
     * Adds a country to the continent.
     *
     * @param country The country being added to continent.
     */
    public void addCountry(Country country){
        countries.add(country);
    }
}