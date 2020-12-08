import java.io.Serializable;
import java.util.*;

/**
 * The default in game world map.
 *
 * DO NOT CHANGE!
 *
 * @author Fareen. L
 * @version 11.08.2020
 */
public class DefaultWorldMap implements IWorldMap, Serializable {

    private HashMap<ContinentName, CountryName[]> continents;
    private HashMap<CountryName, CountryName[]> adjCountries;

    public DefaultWorldMap() {
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
     * Generates the default continents.
     */
    private void _generateContinents() {
        this.continents.put(ContinentName.NorthAmerica, new CountryName[] {
                CountryName.Alaska,
                CountryName.WesternCanada,
                CountryName.CentralAmerica,
                CountryName.EasternUS,
                CountryName.Greenland,
                CountryName.NorthwestTerritories,
                CountryName.CentralCanada,
                CountryName.EasternCanada,
                CountryName.WesternUS
        });
        this.continents.put(ContinentName.SouthAmerica, new CountryName[] {
                CountryName.Argentina,
                CountryName.Brazil,
                CountryName.Peru,
                CountryName.Venezuela
        });
        this.continents.put(ContinentName.Europe, new CountryName[] {
                CountryName.GreatBritain,
                CountryName.Iceland,
                CountryName.NorthernEurope,
                CountryName.Scandinavia,
                CountryName.SouthernEurope,
                CountryName.Ukraine,
                CountryName.WesternEurope
        });
        this.continents.put(ContinentName.Africa, new CountryName[] {
                CountryName.Congo,
                CountryName.EastAfrica,
                CountryName.Egypt,
                CountryName.Madagascar,
                CountryName.NorthAfrica,
                CountryName.SouthAfrica
        });
        this.continents.put(ContinentName.Asia, new CountryName[] {
                CountryName.Afghanistan,
                CountryName.China,
                CountryName.India,
                CountryName.Irkutsk,
                CountryName.Japan,
                CountryName.Kamchatka,
                CountryName.MiddleEast,
                CountryName.Mongolia,
                CountryName.Siam,
                CountryName.Siberia,
                CountryName.Ural,
                CountryName.Yakutsk
        });
        this.continents.put(ContinentName.Australia, new CountryName[] {
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

        // North America
        this.adjCountries.put(CountryName.Alaska, new CountryName[] {
                CountryName.NorthwestTerritories });
        this.adjCountries.put(CountryName.WesternCanada, new CountryName[] {
                CountryName.NorthwestTerritories,
                CountryName.CentralCanada,
                CountryName.WesternCanada,
                CountryName.WesternUS});
        this.adjCountries.put(CountryName.CentralAmerica, new CountryName[] {
                CountryName.EasternUS,
                CountryName.WesternUS,
                CountryName.Venezuela});
        this.adjCountries.put(CountryName.EasternUS, new CountryName[] {
                CountryName.CentralAmerica,
                CountryName.CentralCanada,
                CountryName.WesternUS });
        this.adjCountries.put(CountryName.Greenland, new CountryName[] {
                CountryName.NorthwestTerritories,
                CountryName.CentralCanada,
                CountryName.EasternCanada,
                CountryName.Iceland });
        this.adjCountries.put(CountryName.NorthwestTerritories, new CountryName[] {
                CountryName.Alaska,
                CountryName.WesternCanada,
                CountryName.Greenland,
                CountryName.CentralCanada});
        this.adjCountries.put(CountryName.CentralCanada, new CountryName[] {
                CountryName.WesternCanada,
                CountryName.Greenland,
                CountryName.NorthwestTerritories,
                CountryName.EasternCanada,
                CountryName.EasternUS
        });
        this.adjCountries.put(CountryName.EasternCanada, new CountryName[] {
                CountryName.EasternUS,
                CountryName.Greenland,
                CountryName.NorthwestTerritories,
                CountryName.CentralCanada });
        this.adjCountries.put(CountryName.WesternUS, new CountryName[] {
                CountryName.WesternCanada,
                CountryName.CentralAmerica,
                CountryName.EasternUS,
                CountryName.CentralCanada });

        // South America
        this.adjCountries.put(CountryName.Argentina, new CountryName[] {
                CountryName.Brazil,
                CountryName.Peru });
        this.adjCountries.put(CountryName.Brazil, new CountryName[] {
                CountryName.Argentina,
                CountryName.Peru,
                CountryName.Venezuela});
        this.adjCountries.put(CountryName.Peru, new CountryName[] {
                CountryName.Argentina,
                CountryName.Brazil,
                CountryName.Venezuela });
        this.adjCountries.put(CountryName.Venezuela, new CountryName[] {
                CountryName.Brazil,
                CountryName.Peru,
                CountryName.CentralAmerica});

        // Europe
        this.adjCountries.put(CountryName.GreatBritain, new CountryName[] {
                CountryName.Iceland,
                CountryName.NorthernEurope,
                CountryName.Scandinavia,
                CountryName.WesternEurope });
        this.adjCountries.put(CountryName.Iceland, new CountryName[] {
                CountryName.GreatBritain,
                CountryName.Greenland });
        this.adjCountries.put(CountryName.NorthernEurope, new CountryName[] {
                CountryName.GreatBritain,
                CountryName.Scandinavia,
                CountryName.SouthernEurope,
                CountryName.Ukraine,
                CountryName.WesternEurope });
        this.adjCountries.put(CountryName.Scandinavia, new CountryName[] {
                CountryName.GreatBritain,
                CountryName.Iceland,
                CountryName.NorthernEurope,
                CountryName.Ukraine });
        this.adjCountries.put(CountryName.SouthernEurope, new CountryName[] {
                CountryName.NorthernEurope,
                CountryName.Ukraine,
                CountryName.WesternEurope,
                CountryName.Egypt,
                CountryName.NorthAfrica,
                CountryName.MiddleEast });
        this.adjCountries.put(CountryName.Ukraine, new CountryName[] {
                CountryName.NorthernEurope,
                CountryName.Scandinavia,
                CountryName.SouthernEurope,
                CountryName.Afghanistan,
                CountryName.MiddleEast,
                CountryName.Ural });
        this.adjCountries.put(CountryName.WesternEurope, new CountryName[] {
                CountryName.GreatBritain,
                CountryName.NorthernEurope,
                CountryName.SouthernEurope,
                CountryName.NorthAfrica });

        // Africa
        this.adjCountries.put(CountryName.Congo, new CountryName[] {
                CountryName.EastAfrica,
                CountryName.NorthAfrica,
                CountryName.SouthAfrica });
        this.adjCountries.put(CountryName.EastAfrica, new CountryName[] {
                CountryName.Congo,
                CountryName.Egypt,
                CountryName.Madagascar,
                CountryName.MiddleEast });
        this.adjCountries.put(CountryName.Egypt, new CountryName[] {
                CountryName.EastAfrica,
                CountryName.NorthAfrica,
                CountryName.SouthernEurope,
                CountryName.MiddleEast });
        this.adjCountries.put(CountryName.Madagascar, new CountryName[] {
                CountryName.EastAfrica,
                CountryName.SouthAfrica });
        this.adjCountries.put(CountryName.NorthAfrica, new CountryName[] {
                CountryName.Congo,
                CountryName.Egypt,
                CountryName.Brazil,
                CountryName.SouthernEurope,
                CountryName.WesternEurope });
        this.adjCountries.put(CountryName.SouthAfrica, new CountryName[] {
                CountryName.Congo,
                CountryName.EastAfrica,
                CountryName.Madagascar });

        // Asia
        this.adjCountries.put(CountryName.Afghanistan, new CountryName[] {
                CountryName.China,
                CountryName.India,
                CountryName.MiddleEast,
                CountryName.Ural,
                CountryName.Ukraine });
        this.adjCountries.put(CountryName.China, new CountryName[] {
                CountryName.Afghanistan,
                CountryName.India,
                CountryName.Mongolia,
                CountryName.Siam,
                CountryName.Siberia,
                CountryName.Ural });
        this.adjCountries.put(CountryName.India, new CountryName[] {
                CountryName.Afghanistan,
                CountryName.China,
                CountryName.MiddleEast });
        this.adjCountries.put(CountryName.Irkutsk, new CountryName[] {
                CountryName.Kamchatka,
                CountryName.Mongolia,
                CountryName.Siberia,
                CountryName.Yakutsk });
        this.adjCountries.put(CountryName.Japan, new CountryName[] {
                CountryName.Kamchatka,
                CountryName.Mongolia });
        this.adjCountries.put(CountryName.Kamchatka, new CountryName[] {
                CountryName.Irkutsk,
                CountryName.Japan,
                CountryName.Yakutsk });
        this.adjCountries.put(CountryName.MiddleEast, new CountryName[] {
                CountryName.Afghanistan,
                CountryName.India,
                CountryName.EastAfrica,
                CountryName.Egypt,
                CountryName.SouthernEurope,
                CountryName.Ukraine });
        this.adjCountries.put(CountryName.Mongolia, new CountryName[] {
                CountryName.China,
                CountryName.Irkutsk,
                CountryName.Japan,
                CountryName.Kamchatka,
                CountryName.Siberia });
        this.adjCountries.put(CountryName.Siam, new CountryName[] {
                CountryName.China,
                CountryName.India,
                CountryName.Indonesia });
        this.adjCountries.put(CountryName.Siberia, new CountryName[] {
                CountryName.China,
                CountryName.Irkutsk,
                CountryName.Mongolia,
                CountryName.Ural,
                CountryName.Yakutsk });
        this.adjCountries.put(CountryName.Ural, new CountryName[] {
                CountryName.Afghanistan,
                CountryName.China,
                CountryName.Siberia,
                CountryName.Ukraine });
        this.adjCountries.put(CountryName.Yakutsk, new CountryName[] {
                CountryName.Irkutsk,
                CountryName.Kamchatka,
                CountryName.Siberia });

        // Australia
        this.adjCountries.put(CountryName.EasternAustralia, new CountryName[] {
                CountryName.NewGuinea,
                CountryName.WesternAustralia});
        this.adjCountries.put(CountryName.Indonesia, new CountryName[] {
                CountryName.NewGuinea,
                CountryName.WesternAustralia,
                CountryName.Siam });
        this.adjCountries.put(CountryName.NewGuinea, new CountryName[] {
                CountryName.EasternAustralia,
                CountryName.Indonesia });
        this.adjCountries.put(CountryName.WesternAustralia, new CountryName[] {
                CountryName.EasternAustralia,
                CountryName.NewGuinea,
                CountryName.Indonesia});
    }
}
