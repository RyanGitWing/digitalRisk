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
        NorthAmerica.putAll(setMapContinent(ContinentName.NorthAmerica));
        SouthAmerica.putAll(setMapContinent(ContinentName.SouthAmerica));
        Europe.putAll(setMapContinent(ContinentName.Europe));
        Africa.putAll(setMapContinent(ContinentName.Africa));
        Asia.putAll(setMapContinent(ContinentName.Asia));
        Australia.putAll(setMapContinent(ContinentName.Australia));
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

    public void randAlloc (int playerCount)
    {
        PlayerFactory c = new PlayerFactory();




        // modify to set rulers, army count
        c.
        for (Continent c: map.getWorldMap().values())
        {
            for (int i = 0; i < map.getWorldMap().size();i++)
            {
                if (c.getContinent().get(i).getRuler() == p)
                {
                    System.out.println (c.getContinent().get(i).getName() + " is ruled by Player " + c.getContinent().get(i).getRuler() + " with "
                            + c.getContinent().get(i).getArmyOccupied() + "armies");
                }
                if (c.getContinent().get(i).getRuler() == null) {
                    System.out.println(c.getContinent().get(i).getName() + " is ruled by no one ");
                    i++;
                }
            }
        }
    }
}
