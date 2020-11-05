import java.util.*;

/**
 *  WorldMap Class
 *
 *  Methods:
 *
 *  getWorldMap()
 *  setMapContinent(continentName)
 *  setMap()
 *  armySizeini(int playerCount)
 *  randNumini (continentName)
 *  randAlloc (playerCount, playerList)
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 */

public class WorldMap
{
    private HashMap <ContinentName, Continent> worldMap,NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia;
    private int armySize;


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
        armySize = 0;
    }

    /**
     *
     * Returns the HashMap worldMap, with Key of the enum ContinentName, and value is the respective Continent object
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
     * getCountry(continentName, countryName) will take two enum inputs continentName, countryName. This method will use
     * the enums along with worldMap in a while loop to obtain the Country class Object of the given CountryName enum
     *
     * @param countryName
     * @return Country
     */

    public Country getCountry (CountryName countryName)
    {
        Country countryToReturn = new Country(countryName);

        for (Continent c: worldMap.values())
        {
            for (Country country: c.getContinent())
            {
                if (country.getName() == countryName)
                {
                    countryToReturn = country;
                }
            }
        }
        return countryToReturn;
    }
    public int armySizeini (int playerCount)
    {

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
            randNum = randInt.nextInt(9);
        }
        if (continentName == ContinentName.SouthAmerica){
            randInt = new Random();
            randNum = randInt.nextInt(4);
        }
        if (continentName == ContinentName.Europe){
            randInt = new Random();
            randNum = randInt.nextInt(7);
        }
        if (continentName == ContinentName.Africa){
            randInt = new Random();
            randNum = randInt.nextInt(6);
        }
        if (continentName == ContinentName.Asia){
            randInt = new Random();
            randNum = randInt.nextInt(12);
        }
        if (continentName == ContinentName.Australia){
            randInt = new Random();
            randNum = randInt.nextInt(4);
        }
        return randNum;
    }
    public void randAlloc (int playerCount, List <Player> playerList) {
        Random randInt = new Random();
        Iterator<Continent> continentIterator = worldMap.values().iterator();
        Continent nextContinent = continentIterator.next();
        List <Integer> randIndTrack = new ArrayList<>();

        for (Player p : playerList) {
            p.SetArmyCount(armySizeini(playerCount));
            armySize = p.GetArmyCount();
            while (armySize > 0) {
                int randNum = randNumini(nextContinent.getName());
                int randNum2 = randInt.nextInt(10) + 1;
                if (nextContinent.getContinent().get(randNum).getRuler() != null)
                {
                    while (nextContinent.getContinent().get(randNum).getRuler() != null) {
                        randNum = randNumini(nextContinent.getName());
                        if (nextContinent.getContinent().get(randNum).getRuler() == null) break;
                        else {
                            if (!randIndTrack.contains(randNum) && nextContinent.getContinent().get(randNum).getRuler() != null)
                                randIndTrack.add(randNum);
                            if (randIndTrack.size() == nextContinent.getContinent().size()) break;
                        }
                    }
                    if (!continentIterator.hasNext())
                    {
                        continentIterator = worldMap.values().iterator();
                    }
                    nextContinent = continentIterator.next();
                    randNum = randNumini(nextContinent.getName());
                    randIndTrack.clear();
                }
                Country randCountry = nextContinent.getContinent().get(randNum);
                if (randCountry.getRuler() == null && armySize > 0)
                {
                    randCountry.setRuler(p);
                    p.addNewCountry(randCountry);
                    if ( (armySize - randNum2) < 0)
                    {
                        randNum2 = randInt.nextInt(armySize) + 1;
                    }
                    randCountry.addArmyOccupied(randNum2);
                    armySize -= randNum2;
                    if (!continentIterator.hasNext())
                    {
                        continentIterator = worldMap.values().iterator();
                    }
                    nextContinent = continentIterator.next();
                    randIndTrack.clear();
                }
            }
        }
    }
    // This is a test for random allocation and getPlayerCountry
    public static void main(String[] args) {
        WorldMap t = new WorldMap();
        Player p1 = new Player("player 1");
        Player p2 = new Player("player 2");
        Player p3 = new Player("player 3");
        Player p4 = new Player("player 4");
        Player p5 = new Player("player 5");
        Player p6 = new Player("player 6");
        List <Player> pL = new ArrayList<>();
        pL.add(p1);
        pL.add(p2);
        pL.add(p3);
        pL.add(p4);
        pL.add(p5);
        pL.add(p6);
        t.randAlloc(pL.size(), pL );
        p1.getOwnedCountries().size();
        p2.getOwnedCountries().size();
        p3.getOwnedCountries().size();
        p4.getOwnedCountries().size();
        p5.getOwnedCountries().size();
        p6.getOwnedCountries().size();
    }

}