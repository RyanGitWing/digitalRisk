import java.util.*;

/**
 *  WorldMap Class
 *
 *  Methods:
 *
 *  getWorldMap()
 *  setMapContinent(continentName)
 *  setMap()
 *  getCountriesArmy(continentName,countryName)
 *  setCountriesArmy(continentName,countryName)
 *  getCounry(continentName,countryName)
 *  getPlayer()
 *  setPlayer()
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 */

public class WorldMap
{
    private HashMap <ContinentName, Continent> worldMap,NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia;
    private int randNum1, randNum2, armySize;

    /**
     *   Initializes all of the HashMaps, then calls setMap() method in WorldMap
     * */
    public WorldMap ()
    {
        worldMap = new HashMap<>();
        NorthAmerica = new HashMap<>();
        SouthAmerica = new HashMap<>();
        Europe = new HashMap<>();
        Asia = new HashMap<>();
        Africa = new HashMap<>();
        Australia = new HashMap<>();
        worldMap = setMap();
    }

    /**
     *
     * Returns the HashMap worldMap, with Key of the enum ContinentName, and value of respective Continent object
     *
     * @return worldMap
     * */

    public HashMap<ContinentName, Continent> getWorldMap() {
        return worldMap;
    }

    /**
     *   setMapContinent(continentName) will create a ContinentMap class object, in order to use ContinentMap's method,
     *   setUpContinent which will take continentName as input. The method will also make a tempContinent HashMap which
     *   will store the given ContinentName enum along with the return value of ContinentMap's method, setUpContinent
     *   in the HashMap tempContinent.
     *
     *   @return Finally it will return the HashMap tempContinent, with Key of the enum ContinentName, and value of respective
     *   Continent object. tempContinent will be stored in the respective Continent HashMap
     *   according to the given continentName
     * */

    public HashMap <ContinentName, Continent> setMapContinent (ContinentName continentName)
    {
        ContinentMap continentMap = new ContinentMap();
        HashMap <ContinentName, Continent> tempContinent = new HashMap<>();
        tempContinent.put(continentName, continentMap.setUpContinent(continentName));
        return tempContinent;
    }

    /** setMap() calls setMapContinent(continentName) for each respective Continent HashMap (i.e. NorthAmerica) and uses
     * the same ContinentName enum and putsAll mapping into the Continent HashMap. Then puts all Continent HashMaps into
     * worldMap
     *
     *
     * @return worldMap, the final Map with all of the mappings for every ContinentName enum, Continent class object
     */

    public HashMap<ContinentName, Continent> setMap ()
    {
        NorthAmerica = setMapContinent(ContinentName.NorthAmerica);
        SouthAmerica = setMapContinent(ContinentName.SouthAmerica);
        Europe = setMapContinent(ContinentName.Europe);
        Africa = setMapContinent(ContinentName.Africa);
        Asia = setMapContinent(ContinentName.Asia);
        Australia = setMapContinent(ContinentName.Australia);
        worldMap.putAll(NorthAmerica);
        worldMap.putAll(SouthAmerica);
        worldMap.putAll(Europe);
        worldMap.putAll(Africa);
        worldMap.putAll(Asia);
        worldMap.putAll(Australia);
        return worldMap;
    }

    /**
     * getCountriesArmy(continentName, countryName) will take two enum inputs continentName, countryName and use them
     * along with worldMap in a while loop to obtain the armyCount of the given CountryName enum
     *
     * @param continentName
     * @param countryName
     * @return int
     */

    public int getCountriesArmy (ContinentName continentName, CountryName countryName)
    {
        int count = 0;
        int i = 0;
        while (i <worldMap.get(continentName).getContinent().size())
        {
            if (worldMap.get(continentName).getContinent().get(i).getName() == countryName)
            {
                count = worldMap.get(continentName).getContinent().get(i).getArmyOccupied();
            }
            i++;
        }
        return count;
    }

    /**
     * setCountriesArmy(continentName, countryName, armyCount) will take two enum inputs continentName, countryName and
     * an int value armyCount. This method will use the enums along with worldMap in a while loop
     * to obtain the Country class Object of the given CountryName enum, then set the ArmyCount of that object to
     * the specified value of armyCount
     *
     * @param continentName
     * @param countryName
     * @param armyCount
     */

    public void setCountriesArmy (ContinentName continentName, CountryName countryName, int armyCount)
    {
        int i = 0;
        while (i <worldMap.get(continentName).getContinent().size())
        {
            if (worldMap.get(continentName).getContinent().get(i).getName() == countryName)
            {
                worldMap.get(continentName).getContinent().get(i).addArmyOccupied(armyCount);
            }
            i++;
        }
    }

    /**
     * getCountry(continentName, countryName) will take two enum inputs continentName, countryName. This method will use
     * the enums along with worldMap in a while loop to obtain the Country class Object of the given CountryName enum
     *
     * @param continentName
     * @param countryName
     * @return Country
     */

    public Country getCountry (ContinentName continentName, CountryName countryName)
    {
        int index = 0;
        int i = 0;
        while (i <worldMap.get(continentName).getContinent().size())
        {
            if (worldMap.get(continentName).getContinent().get(i).getName() == countryName)
            {
                index = i;
            }
            i++;
        }
        return worldMap.get(continentName).getContinent().get(index);
    }

    /**
     * getPlayer(continentName, countryName) will take two enum inputs continentName, countryName. This method will
     * use enums along with worldMap in a while loop to obtain the Country class Object of the given CountryName enum
     * then use that to find the ruler of the given Country
     *
     * @param continentName
     * @param countryName
     * @return Player
     */

    public Player getPlayer (ContinentName continentName, CountryName countryName)
    {
        int index = 0;
        int i = 0;
        while (i <worldMap.get(continentName).getContinent().size())
        {
            if (worldMap.get(continentName).getContinent().get(i).getName() == countryName)
            {
                index = i;
            }
            i++;
        }
        return worldMap.get(continentName).getContinent().get(index).getRuler();
    }

    /**
     * setPlayer(continentName, countryName) will take two enum inputs continentName, countryName. This method will
     * use enums along with worldMap in a while loop to obtain the Country class Object of the given CountryName enum
     * then use that to set the Ruler of the given Country
     *
     * @param continentName
     * @param countryName
     *
     */

    public void setPlayer (ContinentName continentName, CountryName countryName, Player player)
    {
        int index = 0;
        int i = 0;
        while (i <worldMap.get(continentName).getContinent().size())
        {
            if (worldMap.get(continentName).getContinent().get(i).getName() == countryName)
            {
                index = i;
            }
            i++;
        }
        worldMap.get(continentName).getContinent().get(index).setRuler(player);
    }

    /**
     *  randAlloc - currently not working
     * */
    public void randAlloc (int playerCount, List <Player> playerList) {
        Random randInt = new Random();
        for (Player p : playerList) {
            if (playerCount == 2) {
                this.armySize = 50;
            }
            if (playerCount == 3) {
                this.armySize = 35;
            }
            if (playerCount == 4) {
                this.armySize = 30;
            }
            if (playerCount == 5) {
                this.armySize = 25;
            }
            if (playerCount == 6) {
                this.armySize = 20;
            }
            for (Continent c : worldMap.values()) {
                for (int i = 0; i < worldMap.size(); i++) {
                    if (c.equals(ContinentName.NorthAmerica)) {
                        randNum2 = randInt.nextInt(9)+1;
                    }
                    if (c.equals(ContinentName.SouthAmerica)) {
                        randInt = new Random();
                        randNum2 = randInt.nextInt(4)+1;
                    }
                    if (c.equals(ContinentName.Europe)) {
                        randInt = new Random();
                        randNum2 = randInt.nextInt(7)+1;
                    }
                    if (c.equals(ContinentName.Africa)) {
                        randInt = new Random();
                        randNum2 = randInt.nextInt(6)+1;
                    }
                    if (c.equals(ContinentName.Asia)) {
                        randInt = new Random();
                        randNum2 = randInt.nextInt(12)+1;
                    }
                    if (c.equals(ContinentName.Australia)) {
                        randInt = new Random();
                        randNum2 = randInt.nextInt(4)+1;
                    }
                    if (c.getContinent().get(randNum2).getRuler() == null && armySize > 0) {
                        c.getContinent().get(randNum2).setRuler(p);
                        c.getContinent().get(randNum2).addArmyOccupied(randNum1);
                        randNum1 = randInt.nextInt(5);
                        i++;
                    }
                    if (c.getContinent().get(i).getRuler() == p || c.getContinent().get(i).getRuler() != null) {
                        i++;
                    }
                }
            }
        }
    }

    // This is a test for random allocation
    public static void main(String[] args) {
        WorldMap t = new WorldMap();
        System.out.println(t.worldMap.size());
        Player p = new Player("job", null);
        Player p2 = new Player("bob", null);
        List <Player> pL = new ArrayList<>();
        pL.add(p);
        pL.add(p2);
        t.randAlloc(2, pL );
    }

}