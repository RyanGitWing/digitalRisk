import java.io.Serializable;
import java.util.*;

/**
 * The default in game world map.
 *
 * DO NOT CHANGE!
 *
 * @author Fareen. L
 * @version 11.08.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */
public class DefaultWorldMap implements IWorldMap, Serializable {

    private final HashMap<String, String[]> continents;
    private final HashMap<String, String[]> adjCountries;
    private final HashMap<String, Integer> bonusArmies;

    public DefaultWorldMap() {
        continents = new HashMap<>();
        adjCountries = new HashMap<>();
        bonusArmies = new HashMap<>();
        _generateContinents();
        _generateAdjacentCountries();
        _generateBonusArmies();
    }

    /**
     * Returns a hashmap of continents and corresponding countries in the default map.
     *
     * @return A hashmap of continent and country names.
     */
    public HashMap<String, String[]> getContinents() { return continents; }

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in the default map.
     *
     * @return A hashmap of country names and corresponding adjacent country names.
     */
    public HashMap<String, String[]> getAdjCountries() { return adjCountries; }

    /**
     * Returns a hashmap of bonus armies corresponding to each continent.
     *
     * @return A hashmap of continents and bonus armies.
     */
    public HashMap<String, Integer> getBonusArmies() { return bonusArmies; }

    /**
     * Generates the default continents.
     */
    private void _generateContinents() {
        this.continents.put("NorthAmerica", new String[] {
                "Alaska",
                "WesternCanada",
                "CentralAmerica",
                "EasternUS",
                "Greenland",
                "NorthwestTerritories",
                "CentralCanada",
                "EasternCanada",
                "WesternUS"
        });
        this.continents.put("SouthAmerica", new String[] {
                "Argentina",
                "Brazil",
                "Peru",
                "Venezuela"
        });
        this.continents.put("Europe", new String[] {
                "GreatBritain",
                "Iceland",
                "NorthernEurope",
                "Scandinavia",
                "SouthernEurope",
                "Ukraine",
                "WesternEurope"
        });
        this.continents.put("Africa", new String[] {
                "Congo",
                "EastAfrica",
                "Egypt",
                "Madagascar",
                "NorthAfrica",
                "SouthAfrica"
        });
        this.continents.put("Asia", new String[] {
                "Afghanistan",
                "China",
                "India",
                "Irkutsk",
                "Japan",
                "Kamchatka",
                "MiddleEast",
                "Mongolia",
                "Siam",
                "Siberia",
                "Ural",
                "Yakutsk"
        });
        this.continents.put("Australia", new String[] {
                "EasternAustralia",
                "Indonesia",
                "NewGuinea",
                "WesternAustralia"
        });
    }

    /**
     * Generates the default adjacent countries.
     */
    private void _generateAdjacentCountries() {

        // North America
        this.adjCountries.put("Alaska", new String[] {
                "NorthwestTerritories" });
        this.adjCountries.put("WesternCanada", new String[] {
                "NorthwestTerritories",
                "CentralCanada",
                "WesternUS"});
        this.adjCountries.put("CentralAmerica", new String[] {
                "EasternUS",
                "WesternUS",
                "Venezuela"});
        this.adjCountries.put("EasternUS", new String[] {
                "CentralAmerica",
                "CentralCanada",
                "WesternUS" });
        this.adjCountries.put("Greenland", new String[] {
                "NorthwestTerritories",
                "CentralCanada",
                "EasternCanada",
                "Iceland" });
        this.adjCountries.put("NorthwestTerritories", new String[] {
                "Alaska",
                "WesternCanada",
                "Greenland",
                "CentralCanada"});
        this.adjCountries.put("CentralCanada", new String[] {
                "WesternCanada",
                "Greenland",
                "NorthwestTerritories",
                "EasternCanada",
                "EasternUS"
        });
        this.adjCountries.put("EasternCanada", new String[] {
                "EasternUS",
                "Greenland",
                "NorthwestTerritories",
                "CentralCanada" });
        this.adjCountries.put("WesternUS", new String[] {
                "WesternCanada",
                "CentralAmerica",
                "EasternUS",
                "CentralCanada" });

        // South America
        this.adjCountries.put("Argentina", new String[] {
                "Brazil",
                "Peru" });
        this.adjCountries.put("Brazil", new String[] {
                "Argentina",
                "Peru",
                "Venezuela"});
        this.adjCountries.put("Peru", new String[] {
                "Argentina",
                "Brazil",
                "Venezuela" });
        this.adjCountries.put("Venezuela", new String[] {
                "Brazil",
                "Peru",
                "CentralAmerica"});

        // Europe
        this.adjCountries.put("GreatBritain", new String[] {
                "Iceland",
                "NorthernEurope",
                "Scandinavia",
                "WesternEurope" });
        this.adjCountries.put("Iceland", new String[] {
                "GreatBritain",
                "Greenland" });
        this.adjCountries.put("NorthernEurope", new String[] {
                "GreatBritain",
                "Scandinavia",
                "SouthernEurope",
                "Ukraine",
                "WesternEurope" });
        this.adjCountries.put("Scandinavia", new String[] {
                "GreatBritain",
                "Iceland",
                "NorthernEurope",
                "Ukraine" });
        this.adjCountries.put("SouthernEurope", new String[] {
                "NorthernEurope",
                "Ukraine",
                "WesternEurope",
                "Egypt",
                "NorthAfrica",
                "MiddleEast" });
        this.adjCountries.put("Ukraine", new String[] {
                "NorthernEurope",
                "Scandinavia",
                "SouthernEurope",
                "Afghanistan",
                "MiddleEast",
                "Ural" });
        this.adjCountries.put("WesternEurope", new String[] {
                "GreatBritain",
                "NorthernEurope",
                "SouthernEurope",
                "NorthAfrica" });

        // Africa
        this.adjCountries.put("Congo", new String[] {
                "EastAfrica",
                "NorthAfrica",
                "SouthAfrica" });
        this.adjCountries.put("EastAfrica", new String[] {
                "Congo",
                "Egypt",
                "Madagascar",
                "MiddleEast" });
        this.adjCountries.put("Egypt", new String[] {
                "EastAfrica",
                "NorthAfrica",
                "SouthernEurope",
                "MiddleEast" });
        this.adjCountries.put("Madagascar", new String[] {
                "EastAfrica",
                "SouthAfrica" });
        this.adjCountries.put("NorthAfrica", new String[] {
                "Congo",
                "Egypt",
                "Brazil",
                "SouthernEurope",
                "WesternEurope" });
        this.adjCountries.put("SouthAfrica", new String[] {
                "Congo",
                "EastAfrica",
                "Madagascar" });

        // Asia
        this.adjCountries.put("Afghanistan", new String[] {
                "China",
                "India",
                "MiddleEast",
                "Ural",
                "Ukraine" });
        this.adjCountries.put("China", new String[] {
                "Afghanistan",
                "India",
                "Mongolia",
                "Siam",
                "Siberia",
                "Ural" });
        this.adjCountries.put("India", new String[] {
                "Afghanistan",
                "China",
                "MiddleEast" });
        this.adjCountries.put("Irkutsk", new String[] {
                "Kamchatka",
                "Mongolia",
                "Siberia",
                "Yakutsk" });
        this.adjCountries.put("Japan", new String[] {
                "Kamchatka",
                "Mongolia" });
        this.adjCountries.put("Kamchatka", new String[] {
                "Irkutsk",
                "Japan",
                "Yakutsk" });
        this.adjCountries.put("MiddleEast", new String[] {
                "Afghanistan",
                "India",
                "EastAfrica",
                "Egypt",
                "SouthernEurope",
                "Ukraine" });
        this.adjCountries.put("Mongolia", new String[] {
                "China",
                "Irkutsk",
                "Japan",
                "Kamchatka",
                "Siberia" });
        this.adjCountries.put("Siam", new String[] {
                "China",
                "India",
                "Indonesia" });
        this.adjCountries.put("Siberia", new String[] {
                "China",
                "Irkutsk",
                "Mongolia",
                "Ural",
                "Yakutsk" });
        this.adjCountries.put("Ural", new String[] {
                "Afghanistan",
                "China",
                "Siberia",
                "Ukraine" });
        this.adjCountries.put("Yakutsk", new String[] {
                "Irkutsk",
                "Kamchatka",
                "Siberia" });

        // Australia
        this.adjCountries.put("EasternAustralia", new String[] {
                "NewGuinea",
                "WesternAustralia"});
        this.adjCountries.put("Indonesia", new String[] {
                "NewGuinea",
                "WesternAustralia",
                "Siam" });
        this.adjCountries.put("NewGuinea", new String[] {
                "EasternAustralia",
                "Indonesia" });
        this.adjCountries.put("WesternAustralia", new String[] {
                "EasternAustralia",
                "NewGuinea",
                "Indonesia"});
    }

    private void _generateBonusArmies() {
        bonusArmies.put("Asia", 7);
        bonusArmies.put("Europe", 5);
        bonusArmies.put("Africa", 3);
        bonusArmies.put("Australia", 2);
        bonusArmies.put("NorthAmerica", 5);
        bonusArmies.put("SouthAmerica", 2);
    }
}
