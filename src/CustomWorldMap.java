import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Use this to build and output custom maps.
 *
 * @author Fareen. L
 * @version 12.08.2020
 */
public class CustomWorldMap implements IWorldMap, Serializable {

    private final HashMap<String, String[]> continents;
    private final HashMap<String, String[]> adjCountries;
    private final HashMap<String, Integer> bonusArmies;

    public CustomWorldMap() {
        continents = new HashMap<>();
        adjCountries = new HashMap<>();
        bonusArmies = new HashMap<>();
        _generateContinents();
        _generateAdjacentCountries();
    }

    /**
     * Returns a hashmap of continents and corresponding countries in the custom map.
     *
     * @return A hashmap of continent and country names.
     */
    public HashMap<String, String[]> getContinents() { return continents; }

    /**
     *  Returns a hashmap of countries and corresponding adjacent countries in the custom map.
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
     * Returns the name of the custom map.
     *
     * @return A name.
     */
    public String getName() { return "America"; }

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
        this.adjCountries.put("NorthAndSouthDakota", new String[] {
                "Montana",
                "Wyoming",
                "Nebraska",
                "Minnesota",
                "Iowa"
        });

        // Midwest
        this.adjCountries.put("Colorado", new String[] {
                "Wyoming",
                "Utah",
                "NewMexico",
                "Oklahoma",
                "Kansas",
                "Nebraska"
        });
        this.adjCountries.put("Nebraska", new String[] {
                "NorthAndSouthDakota",
                "Wyoming",
                "Colorado",
                "Kansas",
                "Missouri",
                "Iowa",
        });
        this.adjCountries.put("Kansas", new String[] {
                "Nebraska",
                "Colorado",
                "Oklahoma",
                "Missouri"
        });
        this.adjCountries.put("Missouri", new String[] {
                "Iowa",
                "Nebraska",
                "Kansas",
                "Oklahoma",
                "Arkansas",
                "Tennessee",
                "Kentucku",
                "Illinois"
        });

        // South
        this.adjCountries.put("NewMexico", new String[] {
                "Colorado",
                "Arizona",
                "Oklahoma",
                "Texas"
        });
        this.adjCountries.put("Oklahoma", new String[] {
                "Kansas",
                "Colorado",
                "NewMexico",
                "Texas",
                "Arkansas",
                "Missouri"
        });
        this.adjCountries.put("Texas", new String[] {
                "Oklahoma",
                "NewMexico",
                "Louisiana",
                "Arkansas"
        });
        this.adjCountries.put("Arkansas", new String[] {
                "Missouri",
                "Oklahoma",
                "Texas",
                "Louisiana",
                "Mississippi",
                "Tennessee"
        });
        this.adjCountries.put("Louisiana", new String[] {
                "Arkansas",
                "Texas",
                "Mississippi"
        });

        // West
        this.adjCountries.put("Washington", new String[] {
                "Oregon",
                "Idaho"
        });
        this.adjCountries.put("Oregon", new String[] {
                "Washington",
                "Idaho",
                "Nevada",
                "NorthCalifornia"
        });
        this.adjCountries.put("Idaho", new String[] {
                "Washington",
                "Oregon",
                "Nevada",
                "Utah",
                "Wyoming",
                "Montana"
        });
        this.adjCountries.put("NorthCalifornia", new String[] {
                "Oregon",
                "Nevada",
                "SouthCalifornia"
        });
        this.adjCountries.put("SouthCalifornia", new String[] {
                "NorthCalifornia",
                "Nevada",
                "Arizona"
        });
        this.adjCountries.put("Nevada", new String[] {
                "Oregon",
                "NorthCalifornia",
                "SouthCalifornia",
                "Arizona",
                "Utah",
                "Idaho"
        });
        this.adjCountries.put("Utah", new String[] {
                "Idaho",
                "Nevada",
                "Arizona",
                "Colorado",
                "Wyoming"
        });
        this.adjCountries.put("Arizona", new String[] {
                "Utah",
                "Nevada",
                "SouthCalifornia",
                "NewMexico"
        });

        // The Lakes
        this.adjCountries.put("Minnesota", new String[] {
                "NorthAndSouthDakota",
                "Iowa",
                "WisconsinAndUpperMichigan"
        });
        this.adjCountries.put("Iowa", new String[] {
                "Minnesota",
                "NorthAndSouthDakota",
                "Nebraska",
                "Missouri",
                "Illinois",
                "WisconsinAndUpperMichigan"
        });
        this.adjCountries.put("WisconsinAndUpperMichigan", new String[] {
                "Minnesota",
                "Iowa",
                "Illinois",
                "LowerMichigan",
                "Indiana"
        });
        this.adjCountries.put("Illinois", new String[] {
                "WisconsinAndUpperMichigan",
                "Iowa",
                "Missouri",
                "Kentucky",
                "Indiana",
                "LowerMichigan"
        });
        this.adjCountries.put("LowerMichigan", new String[] {
                "WisconsinAndUpperMichigan",
                "Illinois",
                "Indiana",
                "Ohio"
        });
        this.adjCountries.put("Indiana", new String[] {
                "LowerMichigan",
                "WisconsinAndUpperMichigan",
                "Illinois",
                "Kentucky",
                "Ohio"
        });
        this.adjCountries.put("Ohio", new String[] {
                "LowerMichigan",
                "Indiana",
                "Kentucky",
                "WestVirginia",
                "Pennsylvania"
        });

        // East Coast
        this.adjCountries.put("Kentucky", new String[] {
                "Ohio",
                "Indiana",
                "Illinois",
                "Missouri",
                "Tennessee",
                "Virginia",
                "WestVirginia"
        });
        this.adjCountries.put("Tennessee", new String[] {
                "Kentucky",
                "Missouri",
                "Arkansas",
                "Mississippi",
                "Alabama",
                "Georgia",
                "NorthAndSouthCarolina",
                "Virginia"
        });
        this.adjCountries.put("Mississippi", new String[] {
                "Tennessee",
                "Arkansas",
                "Louisiana",
                "Alabama"
        });
        this.adjCountries.put("Alabama", new String[] {
                "Tennessee",
                "Mississippi",
                "Florida",
                "Georgia",
        });
        this.adjCountries.put("Florida", new String[] {
                "Alabama",
                "Georgia"
        });
        this.adjCountries.put("Georgia", new String[] {
                "Tennessee",
                "Alabama",
                "Florida",
                "NorthAndSouthDakota"
        });
        this.adjCountries.put("NorthAndSouthCarolina", new String[] {
                "Virginia",
                "Kentucky",
                "Tennessee",
                "Georgia"
        });
        this.adjCountries.put("Virginia", new String[] {
                "WestVirginia",
                "Kentucky",
                "Tennessee",
                "NorthAndSouthCarolina"
        });

        // East Islands
        this.adjCountries.put("Maine", new String[] {
                "VermontAndNewHampshire",
                "Massachusetts"
        });
        this.adjCountries.put("VermontAndNewHampshire", new String[] {
                "Maine",
                "Massachusetts",
                "NewYork"
        });
        this.adjCountries.put("Massachusetts", new String[] {
                "VermontAndNewHampshire",
                "Maine",
                "NewYork",
                "NewJersey"
        });
        this.adjCountries.put("NewYork", new String[] {
                "VermontAndNewHampshire",
                "Massachusetts",
                "NewJersey",
                "Pennsylvania"
        });
        this.adjCountries.put("Pennsylvania", new String[] {
                "NewYork",
                "NewJersey",
                "MarylandAndDelaware",
                "WestVirginia",
                "Ohio"
        });
        this.adjCountries.put("NewJersey", new String[] {
                "Massachusetts",
                "NewYork",
                "Pennsylvania",
                "MarylandAndDelaware"
        });
        this.adjCountries.put("MarylandAndDelaware", new String[] {
                "NewJersey",
                "Pennsylvania",
                "WestVirginia",
                "Virginia"
        });
        this.adjCountries.put("WestVirginia", new String[] {
                "MarylandAndDelaware",
                "Ohio",
                "Kentucky",
                "Virginia"
        });
    }

    private void _generateBonusArmies() {
        this.bonusArmies.put("North", 1);
        this.bonusArmies.put("Midwest", 2);
        this.bonusArmies.put("South", 3);
        this.bonusArmies.put("West", 4);
        this.bonusArmies.put("TheLakes", 3);
        this.bonusArmies.put("EastCoast", 4);
        this.bonusArmies.put("EastIslands", 4);
    }

    private static class CustomMapBuilder {

        public static void main(String[] args) {
            try {
                IWorldMap map = new CustomWorldMap();
                FileOutputStream fOut = new FileOutputStream("americaMap.json");
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
