import java.util.*;

/**
 *  A class to setup the game board.
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 */

public class Board
{
    private final IWorldMap worldMap;
    private final int countryCount;
    private final int continentCount;
    private int initArmySize;
    private HashMap<ContinentName, Continent> boardMap;
    private List<Player> players;
    private List<Country> countries;


    /**
     *  Creates a board with the default world map.
     *
     * */
    public Board()
    {
        this.worldMap = new DefaultWorldMap();
        this.countryCount = worldMap.getAdjCountries().keySet().size();
        this.continentCount = worldMap.getContinents().keySet().size();
        this.boardMap = new HashMap<>();
        this.players = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.initArmySize = 0;
        _setupMap();
    }

    /**
     * Creates a board with a custom world map.
     *
     * @param worldMap The custom world map.
     */
    public Board(IWorldMap worldMap) {
        this.worldMap = worldMap;
        this.countryCount = worldMap.getAdjCountries().keySet().size();
        this.continentCount = worldMap.getContinents().keySet().size();
        this.boardMap = new HashMap<>();
        this.players = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.initArmySize = 0;
        _setupMap();
    }

    /**
     * Returns the board map.
     *
     * @return A hashtable of ContinentNames and corresponding continents.
     */
    public HashMap<ContinentName, Continent> getBoardMap() {
        return boardMap;
    }

    /**
     * Returns a country from the board.
     *
     * @param countryName The name of the country to be retrieved.
     * @return Country A country from the board.
     */
    public Country getCountry(CountryName countryName)
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

        if (playerList.size() > 6 || playerList.size() < 2) throw new IndexOutOfBoundsException();

        this.players = playerList;
        this.initArmySize = _getArmyCount(this.players.size());
        _shuffleCountries();
        _randAlloc();
    }

    /**
     * Sets up the board map.
     */
    private void _setupMap()
    {
        // extract data from world maps
        HashMap<ContinentName, CountryName[]> continents = this.worldMap.getContinents();
        HashMap<CountryName, CountryName[]> adjCountries = this.worldMap.getAdjCountries();


        // create continents and countries with corresponding adjacent countries
        for (ContinentName continentName : continents.keySet()) {

            Continent continent = new Continent(continentName);

            for(CountryName countryName : continents.get(continentName)) {

                Country country = new Country(countryName);
                // grab adjacent countries and assign to local variable country
                country.setAdjCountry(Arrays.asList(adjCountries.get(countryName)));
                continent.addCountry(country);
                countries.add(country);
            }

            this.boardMap.put(continentName, continent);
        }
    }

    /**
     * Shuffles countries between players.
     */
    private void _shuffleCountries() {
        List<Country> shuffledCountries = countries;
        Collections.shuffle(Arrays.asList(shuffledCountries));
        int playerID = 0;

        // assign random countries to players
        for (int i = 0; i < this.countryCount; i++) {
            this.players.get(playerID).addNewCountry(getCountry(shuffledCountries.get(i).getCountryName()));
            playerID = (playerID + 1) % players.size();
        }
    }

    /**
     * Randomly allocates armies to each players' countries.
     */
    private void _randAlloc() {
        Random randGen = new Random();

        for(Player player: this.players) {
            int armyCount = this.initArmySize;
            player.setArmyCount(initArmySize);

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

                int army = randGen.nextInt(armyCount) + 1;
                nextCountry.setArmyOccupied(nextCountry.getArmyOccupied() + army);
                getCountry(nextCountry.getCountryName()).setArmyOccupied(nextCountry.getArmyOccupied());
                armyCount -= army;
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