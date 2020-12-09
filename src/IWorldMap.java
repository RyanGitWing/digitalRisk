import java.util.HashMap;

/**
 * Interface used for all game world maps.
 *
 * @author Fareen. L
 * @version 11.08.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */
public interface IWorldMap {

    /**
     *  Returns a hashmap of countries and corresponding continents in a map.
     *
     * @return A hashmap of continents and countries.
     */
    public HashMap<String, String[]> getContinents();

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in a map.
     *
     * @return A hashmap of country names and corresponding adjacent country names.
     */
    public HashMap<String, String[]> getAdjCountries();

    /**
     * Returns a hashmap of bonus armies corresponding to each continent.
     *
     * @return A hashmap of continents and bonus armies.
     */
    public HashMap<String, Integer> getBonusArmies();
}
