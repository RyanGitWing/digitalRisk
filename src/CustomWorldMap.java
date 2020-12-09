import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Use this to build and output custom maps.
 *
 * @author Fareen. L
 * @version 12.07.2020
 */
public class CustomWorldMap implements IWorldMap, Serializable {

    private HashMap<String, String[]> continents;
    private HashMap<String, String[]> adjCountries;
    private String name = "America";

    public CustomWorldMap() {
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
    public HashMap<String, String[]> getContinents() { return continents; }

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in the default map.
     *
     * @return A hashmap of country names and corresponding adjacent country names.
     */
    public HashMap<String, String[]> getAdjCountries() { return adjCountries; }

    /**
     * Returns the name of the custom map.
     *
     * @return A name.
     */
    public String getName() { return name; }

    /**
     * Generates the default continents.
     */
    private void _generateContinents() {
        this.continents.put("North", new String[] {
                "Montana",
                "Wyoming",
                "NorthAndSouthDakota",
        });
        this.continents.put("Midwest", new String[] {
                "Colorado",
                "Nebraska",
                "Kansas",
                "Missouri"

        });
        this.continents.put("South", new String[] {
                "NewMexico",
                "Oklahoma",
                "Texas",
                "Arkansas",
                "Louisiana"
        });
        this.continents.put("West", new String[] {
                "Washington",
                "Oregon",
                "NorthCalifornia",
                "SouthCalifornia",
                "Idaho",
                "Nevada",
                "Utah",
                "Arizona"
        });
        this.continents.put("TheLakes", new String[] {
                "Minnesota",
                "Iowa",
                "WisconsinAndUpperMichigan",
                "Illinois",
                "LowerMichigan",
                "Indiana",
                "Ohio"
        });
        this.continents.put("EastCoast", new String[] {
                "Kentucky",
                "Tennessee",
                "Mississippi",
                "Alabama",
                "Georgia",
                "Florida",
                "NorthAndSouthCarolina",
                "Virginia"
        });
        this.continents.put("EastIslands", new String[] {
                "Maine",
                "VermontAndNewHampshire",
                "NewYork",
                "Massachusetts",
                "NewJersey",
                "MarylandAndDelaware",
                "Pennsylvania",
                "WestVirgina"
        });
    }

    /**
     * Generates the default adjacent countries.
     */
    private void _generateAdjacentCountries() {

        // North
        this.adjCountries.put("Montana", new String[] {
                "Idaho",
                "Wyoming",
                "NorthAndSouthDakota"
        });
        this.adjCountries.put("Wyoming", new String[] {
                "Montana",
                "Idaho",
                "Utah",
                "Colorado",
                "Nebraska",
                "NorthAndSouthDakota"
        });
        this.adjCountries.put("Colorado", new String[] {
                "Wyoming",
                "Utah",
                "NewMexico",
                "Oklahoma",
                "Kansas",
                "Nebraska"
        });
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

    private static class CustomMapBuilder {

        public static void main(String[] args) {
            try {
                DefaultWorldMap map = new DefaultWorldMap();
                FileOutputStream fOut = new FileOutputStream("defaultMap.json");
                ObjectOutputStream out = new ObjectOutputStream(fOut);
                out.writeObject(map);
                out.close();
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
