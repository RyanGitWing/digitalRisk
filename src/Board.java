import java.io.*;
import java.util.*;

/**
 *  A class to setup the game board.
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 *
 * @author Fareen. L
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */

public class Board
{
    private final IWorldMap worldMap;
    private final int countryCount;
    private final HashMap<String, Continent> boardMap;
    private final List<Country> countries;


    /**
     *  Creates a board with the default world map.
     *
     * */
    public Board()
    {
        this.worldMap = new DefaultWorldMap();
        this.countryCount = worldMap.getAdjCountries().keySet().size();
        this.boardMap = new HashMap<>();
        this.countries = new ArrayList<>();
        _setupMap();
    }

    /**
     * Creates a board with a custom world map.
     *
     * @param filePath The custom world map file path.
     */
    public Board(String filePath) {
        this.worldMap = _deserialize(filePath);
        this.countryCount = worldMap.getAdjCountries().keySet().size();
        this.boardMap = new HashMap<>();
        this.countries = new ArrayList<>();
        _setupMap();
    }

    /**
     * Returns the board map.
     *
     * @return A hashtable of ContinentNames and corresponding continents.
     */
    public HashMap<String, Continent> getBoardMap() {
        return boardMap;
    }

    /**
     * Returns a country from the board.
     *
     * @param countryName The name of the country to be retrieved.
     * @return Country A country from the board.
     */
    public Country getCountry(String countryName)
    {
        for (Continent continent: boardMap.values())
        {
            for (Country country: continent.getCountries())
            {
                if (country.getCountryName() == countryName)
                {
                    return country;
                }
            }
        }
        return null;
    }

    /**
     * Shuffles countries between players and assigns random armies to each country.
     *
     * @param playerList The list of players.
     */
    public void setupPlayers(List <Player> playerList) {

        if (playerList.size() > 6 || playerList.size() < 1) throw new IndexOutOfBoundsException();

        _shuffleCountries(playerList);
        _randAlloc(playerList, _getArmyCount(playerList.size()));
    }

    /**
     * Calculates the total number of bonus armies alloted to a player per turn.
     *
     * @param player The player to allot the bonus armies to.
     * @return The bonus army count.
     */
    public int getBonusArmy(Player player) {
        int bonus = 0;

        bonus = BonusArmy.generalBonus(player.getOwnedCountries().size());

        List<String> ownedContinents = player.getOwnedContinents();
        if (!ownedContinents.isEmpty()) {
            for (String name : ownedContinents) {
                bonus += BonusArmy.continentBonus(name);
            }
        }

        return bonus;
    }

    /**
     * Sets up the board map.
     */
    private void _setupMap()
    {
        // setup bonus armies
        BonusArmy.setupBonus(this.worldMap.getBonusArmies());

        // extract data from world maps
        HashMap<String, String[]> continents = this.worldMap.getContinents();
        HashMap<String, String[]> adjCountries = this.worldMap.getAdjCountries();


        // create continents and countries with corresponding adjacent countries
        for (String continentName : continents.keySet()) {

            Continent continent = new Continent(continentName);

            for(String countryName : continents.get(continentName)) {

                Country country = new Country(countryName, continentName);
                // grab adjacent countries and assign to local variable country
                country.setAdjCountry(Arrays.asList(adjCountries.get(countryName)));
                continent.addCountry(country);
                countries.add(country);
            }

            this.boardMap.put(continentName, continent);
        }
    }

    /**
     * Deserializes a custom map and loads it into the board.
     *
     * @param filePath The filepath for the custom map. Must be a .json.
     * @return An IWorldMap object for the board.
     */
    private IWorldMap _deserialize(String filePath) {
        IWorldMap map = null;
        try {
            FileInputStream fStream = new FileInputStream(filePath);
            ObjectInputStream oStream = new ObjectInputStream(fStream);
            map = (IWorldMap) oStream.readObject();
            oStream.close();
            fStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * Shuffles countries between players.
     */
    private void _shuffleCountries(List<Player> players) {
        Collections.shuffle(this.countries);
        int playerID = 0;

        // assign random countries to players
        for (int i = 0; i < this.countryCount; i++) {
            players.get(playerID).addCountry(getCountry(this.countries.get(i).getCountryName()));
            playerID = (playerID + 1) % players.size();
        }
    }

    /**
     * Randomly allocates armies to each players' countries.
     */
    private void _randAlloc(List<Player> players, int iniArmySize) {
        Random randGen = new Random();

        for(Player player: players) {
            int armyCount = iniArmySize;
            player.setArmyCount(iniArmySize);

            // initially assign 1 army unit to each country
            for (Country country : player.getOwnedCountries()) {
                country.setArmyOccupied(1);
                country.setRuler(player);
                armyCount--;
            }

            Iterator<Country> countryIterator = player.getOwnedCountries().iterator();
            Country nextCountry = countryIterator.next();

            //randomly allocate rest of the army
            while (armyCount != 0) {
                int army = (randGen.nextInt(armyCount + 1) %
                        (randGen.nextInt(player.getOwnedCountries().size()) + 1));
                nextCountry.setArmyOccupied(nextCountry.getArmyOccupied() + army);
                getCountry(nextCountry.getCountryName()).setArmyOccupied(nextCountry.getArmyOccupied());
                armyCount -= army;
                if (countryIterator.hasNext()) nextCountry = countryIterator.next();
            }
        }
    }

    /**
     * Gets the starting army size assigned to each player depending on the number of players.
     *
     * @param playerCount The number of players.
     * @return The army size allocated to each player.
     */
    private int _getArmyCount(int playerCount)
    {
        switch(playerCount) {
            case 2:
                return 50;
            case 3:
                return 35;
            case 4:
                return 30;
            case 5:
                return 25;
            case 6:
                return 20;
        }
        return 0;
    }
}