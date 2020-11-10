import java.util.HashMap;

/**
 * Class for testing Board and WorldMaps.
 * todo: Convert to CustomWorldMap for custom map functionality.
 *
 * @author Fareen. L
 * @version 11.09.2020
 */
public class TestWorldMap implements IWorldMap{
    private HashMap<ContinentName, CountryName[]> continents;
    private HashMap<CountryName, CountryName[]> adjCountries;

    public TestWorldMap() {
        continents = new HashMap<>();
        adjCountries = new HashMap<>();
        _generateContinents();
        _generateAdjacentCountries();
    }

    /**
     * Returns a hashmap of continents and corresponding countries in the default map.
     *
     * @return A hashmap of continent and country names.
     */
    public HashMap<ContinentName, CountryName[]> getContinents() { return continents; }

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in the default map.
     *
     * @return A hashmap of country names and corresponding adjacent country names.
     */
    public HashMap<CountryName, CountryName[]> getAdjCountries() { return adjCountries; }

    /**
     * Generates continents.
     */
    private void _generateContinents() {
        this.continents.put(ContinentName.Australia, new CountryName[]{
                CountryName.EasternAustralia,
                CountryName.Indonesia,
                CountryName.NewGuinea,
                CountryName.WesternAustralia
        });
    }
    /**
     * Generates the default adjacent countries.
     */
    private void _generateAdjacentCountries() {
        this.adjCountries.put(CountryName.EasternAustralia, new CountryName[] { CountryName.NewGuinea });
        this.adjCountries.put(CountryName.Indonesia, new CountryName[] { CountryName.NewGuinea });
        this.adjCountries.put(CountryName.NewGuinea, new CountryName[] { CountryName.EasternAustralia });
        this.adjCountries.put(CountryName.WesternAustralia, new CountryName[] { CountryName.EasternAustralia });
    }
}
