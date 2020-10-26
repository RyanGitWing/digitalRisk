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
 * Author: Vis Kirubakaran
 * Version: 10.25.2020
 */

public class WorldMap
{
    private HashMap <ContinentName, Continent> worldMap,NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia;

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


    // split two player countries into North and South America (50 army count,
    public void randAlloc (int playerCount, List <Player> playerList)
    {
        int armySize = 0;
        Random randInt = new Random();
        int randContinent = randInt.nextInt(6 + 1);
        int randCountry = randInt.nextInt(24 + 1);
        int randArmy = randInt.nextInt(5);

        if (playerCount == 2)
        {
            armySize = 50;
        }
        if (playerCount == 3)
        {
            armySize = 35;
        }
        if (playerCount == 4)
        {
            armySize = 30;
        }
        if (playerCount == 5)
        {
            armySize = 25;
        }
        if (playerCount == 6)
        {
            armySize = 20;
        }
            for (Player p: playerList)
            {
                for (Continent c: worldMap.values())
                {
                    {
                        for (int i = 0; i < worldMap.size(); i++) {
                            if (c.getContinent().get(randCountry).getRuler() == null && armySize > 0) {
                                c.getContinent().get(randCountry).setRuler(p);
                                c.getContinent().get(randCountry).addArmyOccupied(randArmy);
                                randArmy = randInt.nextInt(5);
                                randCountry = randInt.nextInt(24 + 1);
                                i++;
                            }
                            if (c.getContinent().get(i).getRuler() == p) {
                                i++;
                                randCountry = randInt.nextInt(24 + 1);
                            }
                        }
                    }
                }
            }
        }

}
