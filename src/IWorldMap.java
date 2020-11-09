import java.util.HashMap;

/**
 * Interface used for all game world maps.
 *
 * @author Fareen. L
 * @version 11.08.2020
 */
public interface IWorldMap {

    /**
     *  Returns a hashmap of countries and corresponding continents in a map.
     *
     * @return A hashmap of continents and countries.
     */
    public HashMap<ContinentName, CountryName[]> getContinents();

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in a map.
     *
     * @return A hashmap of country names and corresponding adjacent country names.
     */
    public HashMap<CountryName, CountryName[]> getAdjCountries();
}
