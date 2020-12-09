import java.io.*;
import java.util.*;

/**
 * Risk Game, a turn-based world domination game where players take turn fighting each other to the death until only
 * one player remain conquering the whole world.
 *
 * @author Ryan. N
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.09.2020
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 *
 * @author Vyasan. J
 * @version 11.22.2020
 */
public class Game implements Serializable
{
    private Dice die;
    private static ArrayList<Player> playerList;
    private static int numPlayers;
    private static int numHumanPlayers;
    private static int numAIPlayers;
    private int playerIndex;
    private static Board board;
    private Player currentPlayer, enemyPlayer;
    private int numAtkArmy, numDefArmy;
    private Country countryOwn, enemyCountry;
    private Boolean hasWon;
    private List <RiskView> riskViews;
    private String outcome = "", diceValue = "", atkOutput = "";


    /**
     * Creates a game and initialise its internal map.
     */
    public Game(ArrayList<Player> pL, int tP, int hP, int aI, int pI, Board b, Player c)
    {
        playerList = pL;
        numPlayers = tP;
        numHumanPlayers = hP;
        numAIPlayers = aI;
        playerIndex = pI;
        board = b;
        currentPlayer = c;

        riskViews = new ArrayList<>();
    }

    /**
     * Creates a game and initialise its internal map.
     *
     * @param humanPlayerCount number of players playing the game.
     */
    public Game(int humanPlayerCount, int AIPlayerCount)
    {
        playerList = new ArrayList<>();
        board = new Board();
        riskViews = new ArrayList<>();

        this.numHumanPlayers = humanPlayerCount;
        this.numAIPlayers = AIPlayerCount;
        this.numPlayers = humanPlayerCount + AIPlayerCount;

        _retrievePlayers();
    }

    /**
    * Updates the RiskViews in riskViews as the game progresses.
    * */
    public void update ()
    {
        for (RiskView rv : riskViews)
        {
            rv.handleGameUpdate(new RiskEvent(this));
        }
    }

    /**
     * Adds a RiskView object to the game.
     *
     * @param rv The RiskView object to add to the game.
     */
    public void addRiskView(RiskFrame rv) { riskViews.add(rv);}

    /**
     * Removes a RiskView object from the game.
     *
     * @param rv The RiskView object to remove from the game.
     */
    public void removeRiskView(RiskFrame rv) { riskViews.remove(rv);}

    /**
     * Returns the game board.
     *
     * @return The board containing the world map.
     */
    public Board getBoardMap() {
        return board;
    }

    /**
     * Returns the result of a battle (Dice Rolls and if a country was claimed and by whom).
     *
     * @return String containing battle outcome.
     */
    public String getAtkOutput() {
        String output = atkOutput;
        atkOutput = "";
        return output;
    }

    /**
     * Returns the list of players.
     *
     * @return The list containing the players in the game.
     */
    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Returns the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the number of players from the user and sets them up.
     */
    private void _retrievePlayers()
    {
        playerList = new ArrayList<>();
        int i ;
        for ( i = 0; i < numHumanPlayers; i++) {

            playerList.add(new Player("Player" + (i + 1)));
        }

        if (numAIPlayers != 0) {
            for (int j = 0; j < numAIPlayers; j++) {
                playerList.add(new AIPlayer("AIPlayer" + (i + 1 + j)));
            }

        }
        playerIndex = 0;
        currentPlayer = playerList.get(playerIndex);
        board.setupPlayers(playerList);


    }

    /**
     * Attack action method.
     *
     * @param attacker The attacking player.
     * @param numArmy The number of army used to attack.
     * @param defender The defending player.
     * @return The result of the battle.
     */
    public String attackCMD(String attacker, int numArmy, String defender) {

        String atkOutput = "" ;

        countryOwn = board.getCountry(CountryName.valueOf(attacker));

        List<CountryName> countryOwnAdj = countryOwn.getAdjCountries();

        enemyCountry = board.getCountry(CountryName.valueOf(defender));
        enemyPlayer = enemyCountry.getRuler();

        if (!currentPlayer.equals(enemyPlayer)) {

            numAtkArmy = numArmy;

            // Check if the country being attack has zero army
            // If so then takeover the country without commencing battlephase
            if (enemyCountry.getArmyOccupied() == 0) {

                enemyCountry.setRuler(currentPlayer);
                currentPlayer.addCountry(enemyCountry);
                enemyCountry.setArmyOccupied(numAtkArmy);
                countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);
                outcome += "You have claimed " + enemyCountry;

            }

            // Check to see if the current player has the military force to attack.
            else {
                // Onto war!!!
                battlePhase();
            }
        }

        else {
            outcome = "\n You own this country stupid!!!\n" + "Attack another country \n";
            return outcome;
        }

        atkOutput += diceValue + outcome;
        this.atkOutput = atkOutput;
        diceValue = "";
        outcome = "";
        return atkOutput;
    }

    /**
     * This method handles the battle phase between players. By rolling a
     * dice based on the number of troops deployed.
     */
    private void battlePhase() {

        // An arraylist to store dice.
        ArrayList<Integer> atkList = new ArrayList<>();
        ArrayList<Integer> defList = new ArrayList<>();

        die = new Dice();

        numDefArmy = 0;

        // Fill up the array with the values of the dice.
        for (int i = 0; i < Math.min(numAtkArmy, countryOwn.getArmyOccupied()); i++) {

            die.rollDice();
            atkList.add(die.getValue());
            diceValue += currentPlayer.getName() + " Dice: " + (i + 1) +  " Value: " + atkList.get(i);
            diceValue += "\n";

        }

        if (enemyCountry.getArmyOccupied() >= 2) {
            numDefArmy = 2;
        } else {
            numDefArmy = 1;
        }

        for (int i = 0; i < numDefArmy; i++) {

            die.rollDice();
            defList.add(die.getValue());
            diceValue += enemyPlayer.getName() + " Dice: " + (i + 1) + " Value: " + defList.get(i);
            diceValue += "\n";

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

        turnOutcome();

    }

    /**
     * Checks the outcome if a player won a country.
     *
     * @return
     */
    public Boolean turnOutcome() {

        hasWon = false;

        // If there are no more troops in the country, player takes over the country.
        if (countryOwn.getArmyOccupied() == 0) {

            countryOwn.setRuler(enemyPlayer); // Set the new Ruler
            enemyPlayer.addCountry(countryOwn); // Add the country to the new Ruler
            countryOwn.setArmyOccupied(numDefArmy); // put the army that was fighting in the new country
            currentPlayer.removeCountry(countryOwn);
            enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - numDefArmy); // sub the num of army that was fighting

            // If the the current player total army count falls to zero, remove player from game.
            if (currentPlayer.getArmyCount() == 0) {
                removePlayer(currentPlayer);
            }

            outcome = "NEWS: " + currentPlayer.getName() + " has lost " + countryOwn.getCountryName() + " to " + enemyPlayer.getName() + ". \n";
        }

        // If there are no more troops in the country, player takes over the country.
        if (enemyCountry.getArmyOccupied() == 0) {

            hasWon = true;

            enemyCountry.setRuler(currentPlayer);
            currentPlayer.addCountry(enemyCountry);
            enemyCountry.setArmyOccupied(numAtkArmy); // Should check to make sure at least one army in countryOwn

            enemyPlayer.removeCountry(enemyCountry);
            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);

            // If the enemy total army count falls to zero, remove player from game.
            if (enemyPlayer.getArmyCount() == 0) {
                removePlayer(enemyPlayer);
            }

            outcome = "NEWS: " + currentPlayer.getName() + " has won " + enemyCountry.getCountryName() + " from " + enemyPlayer.getName() + ". \n";

        }

        return hasWon;


    }

    /**
     * Remove the player who has no more army from the game.
     *
     * @param dead The player to remove from the game
     */
    private void removePlayer(Player dead){

        outcome = "NEWS: " + dead + " has been eliminated from the game!";

        playerList.remove(dead);

    }

    /**
     * Updates the current player to next player.
     */
    public void nextPlayer() {

        playerIndex++;

        // If the index is bigger or equal to the player list go back to index 0
        if (playerIndex >= playerList.size()){
            playerIndex = 0;

        }

        // Player that is playing according to index.
        currentPlayer = playerList.get(playerIndex);

    }

    /**
     * Checks for a path based on adjacent owned countries of the current player from a starting country and a goal country.
     * While updating the list of visited countries, through traversal.
     *
     * @return path Whether or not a path exists, true if it does and false if not
     */
    public boolean pathCheck(String curr, List <String> visited, String goal) {
        boolean path = false;
        Country currCountry = getBoardMap().getCountry(CountryName.valueOf(curr)); // current country
        List<CountryName> adjC = currCountry.getAdjCountries(); // list of adj countries to curr
        List<CountryName> ownedC = new ArrayList<>(); // list of adj owned countries
        for (CountryName countryName : adjC) {
            if (getBoardMap().getCountry(countryName).getRuler().getName().equals(currentPlayer.getName())) {
                ownedC.add(countryName); // add the adj country to ownedC list
            }
        }
        if (curr.equals(goal))
        {
            path = true; // from initial curr to the final goal country, a path has been found
        }
        else {
            if (!(visited.contains(curr))) visited.add(curr); // add to visited countries list
            for (CountryName countryName : ownedC) {
                // recursive call all countryName in ownedC that are not in visited countries list
                if (!visited.contains(countryName.toString())) return pathCheck(countryName.toString(), visited, goal);
            }
        }
        return path;
    }

    /**
     * This method allows the user to save the state of the game.
     *
     * @param file The file which the game will save to.
     */
    public void saveG(String file){
        //save the state of the game in another object
        GameState gS = new GameState(playerList,numPlayers, numHumanPlayers, numAIPlayers, playerIndex, board, currentPlayer);
        //write the game state object onto a file
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gS);
            out.close();
            fileOut.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method allows the user to load the most recent saved game.
     *
     * @param file The file which the game will load.
     * @return Return the saved game.
     */
    public static Game loadG(String file){

        try {
            //read the file and load it to a new game
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameState gS = (GameState) in.readObject();
            Game game = new Game(gS.getPL(), gS.getTP(), gS.getHP(), gS.getAI(), gS.getPI(), gS.getB(), gS.getC());
            in.close();
            fileIn.close();
            return game;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
