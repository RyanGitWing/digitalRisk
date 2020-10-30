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
 *  getCountry(continentName,countryName)
 *  getPlayer()
 *  setPlayer()
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
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
            if (getCountry(continentName, countryName).getName() == countryName)
            {
                count = getCountry(continentName, countryName).getArmyOccupied();
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
            if (getCountry(continentName, countryName).getName() == countryName)
            {
                getCountry(continentName, countryName).addArmyOccupied(armyCount);
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
     * setPlayer(continentName, countryName) will take two enum inputs continentName, countryName. This method will
     * use enums along with worldMap in a while loop to obtain the Country class Object of the given CountryName enum
     * then use that to set the Ruler of the given Country
     *
     * @param continentName
     * @param countryName
     * @param player
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


    // work in progress
    public List <Country> getPlayerCountry (Player p)
    {
        List <Country> playerCountries = new ArrayList<>();
        for (Continent c: worldMap.values())
        {
            for (int i = 0; i < c.getContinent().size(); i ++)
            {
                if (c.getContinent().get(i).getRuler() == p)
                {
                    playerCountries.add(c.getContinent().get(i));
                }
                i++;
            }
        }
        return playerCountries;
    }
    public int armySizeini (int playerCount)
    {
        int armySize = 0;
        if (playerCount == 2) {
            armySize = 50;
        }
        if (playerCount == 3) {
            armySize = 35;
        }
        if (playerCount == 4) {
            armySize = 30;
        }
        if (playerCount == 5) {
            armySize = 25;
        }
        if (playerCount == 6) {
            armySize = 20;
        }
        return armySize;
    }
    public int randNumini (ContinentName continentName)
    {
        Random randInt = new Random();
        int randNum = 0;

        if (continentName == ContinentName.NorthAmerica){
            randNum = randInt.nextInt(8);
        }
        if (continentName == ContinentName.SouthAmerica){
            randInt = new Random();
            randNum = randInt.nextInt(3);
        }
        if (continentName == ContinentName.Europe){
            randInt = new Random();
            randNum = randInt.nextInt(6);
        }
        if (continentName == ContinentName.Africa){
            randInt = new Random();
            randNum = randInt.nextInt(5);
        }
        if (continentName == ContinentName.Asia){
            randInt = new Random();
            randNum = randInt.nextInt(11);
        }
        if (continentName == ContinentName.Australia){
            randInt = new Random();
            randNum = randInt.nextInt(3);
        }
        return randNum;
    }
    public void randAlloc (int playerCount, List <Player> playerList)
    {
        Random randInt = new Random();
        for (Player p : playerList)
        {
            int armySize = armySizeini(playerCount);
            Iterator<Continent> continentIterator = worldMap.values().iterator();
            ListIterator<Country> countryListIterator = continentIterator.next().getContinent().listIterator();
            Country nextCountry = countryListIterator.next();
            Continent nextContinent = continentIterator.next();

            while (armySize > 0)
                {
                    int randNum = randNumini(nextContinent.getName());
                    int randNum2 = randInt.nextInt(5) + 1;
                    Country randCountry = nextContinent.getContinent().get(randNum);
                    if (randCountry.getRuler() == null && armySize > 0)
                    {
                        randCountry.setRuler(p);
                        if ((armySize - randNum2 < 0))
                        {
                            randNum2 = randInt.nextInt(armySize) + 1;
                        }
                            randCountry.addArmyOccupied(randNum2);
                            armySize -= randNum2;
                    }
                    else if (randCountry.getRuler() != null && armySize > 0)
                    {
                        if (randCountry.getName() != nextCountry.getName() && nextCountry.getRuler() == null)
                        {
                            nextCountry.setRuler(p);
                            if ((armySize - randNum2 < 0))
                            {
                                randNum2 = randInt.nextInt(armySize) + 1;
                            }
                            nextCountry.addArmyOccupied(randNum2);
                            armySize -= randNum2;
                        }
                    }
                    if (countryListIterator.hasNext())
                    {
                        nextCountry = countryListIterator.next();
                    }
                    else
                        {
                            if (continentIterator.hasNext())
                            {
                                nextContinent = continentIterator.next();
                            }
                            else break;
                        }
                }
        }
    }

    // This is a test for random allocation and getPlayerCountry
    public static void main(String[] args) {
        WorldMap t = new WorldMap();
        Player p = new Player("tom", null);
        Player p2 = new Player("bob", null);
        List <Player> pL = new ArrayList<>();
        pL.add(p);
        pL.add(p2);
        t.randAlloc(2, pL );
        t.getPlayerCountry(p);
        t.getPlayerCountry(p2);
    }

}