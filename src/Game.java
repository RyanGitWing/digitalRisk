import java.util.*;

/**
 * Risk Game, a turn-based world domination game where players take turn fighting each other to the death until only
 * one player remain conquering the whole world.
 *
 * @author Ryan Nguyen
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 */
public class Game
{
    private static Parser parser;

    private Dice die;

    private static ArrayList<Player> playerList;

    private static int numPlayers;

    private int playerIndex;

    private static Board board;

    private boolean hasAtk;

    private Player currentPlayer, enemyPlayer;

    private int numAtkArmy;

    private Country countryOwn, enemyCountry;

    private List <RiskView> riskViews;



    /**
     * Creates the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        playerList = new ArrayList<>();
        board = new Board();
        hasAtk = false;
    }

    /**
     * Create the game and initialise its internal map
     * @param playerCount the number of players playing the game
     */
    public Game(int playerCount)
    {
        playerList = new ArrayList<>();
        board = new Board();
        hasAtk = false;
        riskViews = new ArrayList<>();

        this.numPlayers = playerCount;

        _retrievePlayers();
    }

    public String updateStatus ()
    {
        return _getGameStatus();
    }

    public Board getBoardMap() {
        return board;
    }

    public void addRiskView(RiskFrame rv) { riskViews.add(rv);}

    public void removeRiskView(RiskFrame rv) { riskViews.remove(rv);}

    /**
     * Gets the number of players from the user and sets them up.
     */
    private void _retrievePlayers()
    {
        playerList = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {

            playerList.add(new Player("Player" + (i + 1)));

        }

        // Initialize the starting player.
        playerIndex = 0;
        currentPlayer = playerList.get(playerIndex);

        board.setupPlayers(playerList);
    }


    /**
     * Method which returns the state of the game.
     * The number of armies and countries owned by each player.
     */
    public String _getGameStatus()
    {
        String playersInfo = "";
        String pInfo = "";

        String currentTurn = "";

        for (Player p : playerList){
            playersInfo += p.toString();
            String ownedCountries = "";
            for (Country c : p.getOwnedCountries())
            {
                ownedCountries += c.getCountryName().name() + " ";
            }
            pInfo += p.getName() + " owns the following countries: " + ownedCountries + "\n";
        }

        currentTurn += "It's currently " + currentPlayer.getName() + "'s turn. \n";
        return playersInfo + "\n" + pInfo + "\n" + currentTurn;
    }

    public void attackCMD(String attacker, int numArmy, String defender) {

        if (!hasAtk) {

            countryOwn = board.getCountry(CountryName.valueOf(attacker));

            List<CountryName> countryOwnAdj = countryOwn.getAdjCountries();

            // Check to see if the current player owns this country.
            if (currentPlayer.equals(countryOwn.getRuler())) {

                enemyCountry = board.getCountry(CountryName.valueOf(defender));
                enemyPlayer = enemyCountry.getRuler();

                // Check to make sure the current player is not attacking a country they own.
                if (!currentPlayer.equals(enemyPlayer)) {

                    // Check to see if the country being attacked is an adjacent country.
                    if (countryOwnAdj.contains(enemyCountry.getCountryName())) {

                        numAtkArmy = numArmy;

                        // Check if the country being attack has zero army
                        // If so then takeover the country without commencing battlephase
                        if (enemyCountry.getArmyOccupied() == 0) {

                            enemyCountry.setRuler(currentPlayer);
                            currentPlayer.addNewCountry(enemyCountry);
                            enemyCountry.setArmyOccupied(numAtkArmy);
                            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);

                        }

                        // Check to see if the current player has the military force to attack.
                        else if (numAtkArmy <= countryOwn.getArmyOccupied() && numAtkArmy <= 3) {

                            // Onto war!!!
                            battlePhase();
                            System.out.println("Battle Phase Over!");

                        } else {
                            System.out.println("You do not own this many troops for " + attacker + ".");
                            System.out.println("Try attacking again or another cmd.");
                        }

                    } else {
                        System.out.println(defender + " is not adjacent to " + attacker + ".");
                        System.out.println("Try attacking again or another cmd.");
                    }

                } else {
                    System.out.println("You own this country stupid!!!");
                    System.out.println("Try attacking again or another cmd.");
                }

            } else {
                System.out.println("You do not own this country.");
                System.out.println("Try attacking again or another cmd.");
            }
        }

        else {
            System.out.println("You have already attacked!");
        }


    }

    /**
     * This method handles the battle phase between players. By rolling a
     * die based on the number of troops deployed.
     */
    private void battlePhase() {

        // An arraylist to store dice.
        ArrayList<Integer> atkList = new ArrayList<>();
        ArrayList<Integer> defList = new ArrayList<>();

        die = new Dice();

        int numDefArmy = 0;

        // Fill up the array with the values of the dice.
        for (int i = 0; i < Math.min(numAtkArmy, countryOwn.getArmyOccupied()); i++) {

            die.rollDice();
            atkList.add(die.getValue());
            System.out.println(currentPlayer.getName() + " Dice: " + (i + 1) +  " Value: " + atkList.get(i));
            System.out.println();

        }

        if (enemyCountry.getArmyOccupied() >= 2) {
            numDefArmy = 2;
        } else {
            numDefArmy = 1;
        }

        for (int i = 0; i < numDefArmy; i++) {

            die.rollDice();
            defList.add(die.getValue());
            System.out.println(enemyPlayer.getName() + " Dice: " + (i + 1) + " Value: " + defList.get(i));
            System.out.println();

        }

        // Arrange the dice value in descending order.
        if (numAtkArmy > 1) {
            Collections.sort(atkList, Collections.reverseOrder());
        }
        else {

        }
        if (numDefArmy > 1) {
            Collections.sort(defList, Collections.reverseOrder());
        }

        // Compare the values from the attacker side and defender side
        if (atkList.get(0) > defList.get(0)) {
            enemyPlayer.setArmyCount(enemyPlayer.getArmyCount() - 1); // sub an army from enemy player
            enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - 1); // sub an army from enemy country
            numDefArmy--;
        }

        else {
            currentPlayer.setArmyCount(currentPlayer.getArmyCount() - 1); // sub an army from current player
            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - 1); // sub an army from current country
            numAtkArmy--;
        }

        if (atkList.size() >= 2 && defList.size() >= 2){

            if (atkList.get(1) > defList.get(1)) {
                enemyPlayer.setArmyCount(enemyPlayer.getArmyCount() - 1);
                enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - 1);
                numDefArmy--;
            }

            else {
                currentPlayer.setArmyCount(currentPlayer.getArmyCount() - 1);
                countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - 1);
                numAtkArmy--;
            }

        }

        // If there are no more troops in the country, player takes over the country.
        if (countryOwn.getArmyOccupied() == 0) {

            countryOwn.setRuler(enemyPlayer); // Set the new Ruler
            enemyPlayer.addNewCountry(countryOwn); // Add the country to the new Ruler
            countryOwn.setArmyOccupied(numDefArmy); // put the army that was fighting in the new country
            currentPlayer.removeNewCountry(countryOwn);
            enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - numDefArmy); // sub the num of army that was fighting

            // If the the current player total army count falls to zero, remove player from game.
            if (currentPlayer.getArmyCount() == 0) {
                removePlayer(currentPlayer);
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has lost " + countryOwn.getCountryName() + " to " + enemyPlayer.getName() + ".");
            hasAtk = true;
            return;
        }

        // If there are no more troops in the country, player takes over the country.
        if (enemyCountry.getArmyOccupied() == 0) {

            enemyCountry.setRuler(currentPlayer);
            currentPlayer.addNewCountry(enemyCountry);
            enemyCountry.setArmyOccupied(numAtkArmy); // Should check to make sure at least one army in countryOwn
            enemyPlayer.removeNewCountry(enemyCountry);
            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);

            // If the enemy total army count falls to zero, remove player from game.
            if (enemyPlayer.getArmyCount() == 0) {
                removePlayer(enemyPlayer);
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has won " + enemyCountry.getCountryName() + " from " + enemyPlayer.getName() + ".");
        }

        hasAtk = true;

    }

    /**
     * Remove the player who has no more army from the game.
     *
     * todo: Fareen refactor.
     *
     * @param dead The player to remove from the game
     */
    private void removePlayer(Player dead){

        System.out.println("NEWS: " + dead + " has been eliminated from the game!");

        playerList.remove(dead);

    }


    /**
     * "endturn" was entered. Check the rest of the command to see
     * whether we really want to pass our turn to the following player.
     *
     * todo: Fareen refactor.
     *
     */
    public void nextPlayer() {

        playerIndex++;

        // If the index is bigger or equal to the player list go back to index 0
        if (playerIndex >= playerList.size()){
            playerIndex = 0;

        }

        // Player that is playing according to index.
        currentPlayer = playerList.get(playerIndex);
        hasAtk = false;
        _getGameStatus();


    }
}
