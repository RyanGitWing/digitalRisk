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

    private Player currentPlayer;

    private int numAtkArmy;

    private Country countryOwn, enemyCountry;

    private List <RiskFrame> riskFrames;



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
        riskFrames = new ArrayList<>();

        this.numPlayers = playerCount;

        _retrievePlayers();
    }

    public Board getBoardMap() {
        return board;
    }

    public void addRiskView(RiskFrame rv) { riskFrames.add(rv);}

    public void removeRiskView(RiskFrame rv) { riskFrames.remove(rv);}


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        _retrievePlayers();
        _printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;

        while (! finished) {
            Command command = parser.getCommand();
            finished = _processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye!");
    }

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
     * Print out the opening message for the player.
     */
    private void _printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Risk!");
        System.out.println("Risk is a turn-based world domination game.\n");
        _getGameStatus();
        System.out.println("Type 'help' if you need help. \n");
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

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean _processCommand(Command command)
    {
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case "help":
                _printHelp();
                break;
            case "quit":
                return true;
            case "status":
                _status();
                break;
            case "attack":
                _attackCMD(command);
                break;
            case "endturn":
                nextPlayer();
                break;
        }

        return false;
    }

    /**
     * Print out some help information for the player.
     */
    private void _printHelp()
    {
        System.out.println("Your command words are: quit help status attack endturn");
    }

    /**
     * "Status" was entered. Prints out the game status.
     */
    private void _status() {
        _getGameStatus();

    }

    /**
     * "Attack" was entered. Check the rest of the command to see
     * where we attacking with how many troops.
     *
     * todo: Fareen refactor.
     *
     * @param command The command to be processed.
     */
    private void _attackCMD(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Attack what?");
        }

        if (!hasAtk) {

            Scanner reader = new Scanner(System.in);

            System.out.println("Which country is attacking?");
            String attacker = reader.nextLine();

            countryOwn = board.getCountry(CountryName.valueOf(attacker));

            List<CountryName> countryOwnAdj = countryOwn.getAdjCountries();
            String countryAtkOpt = "";
            for (CountryName countryName : countryOwnAdj) {
                countryAtkOpt += countryName + " ";
            }
            System.out.println("The available countries to attack are: " + countryAtkOpt);

            // Check to see if the current player owns this country.
            if (currentPlayer.equals(countryOwn.getRuler())) {

                System.out.println("Which country do you want to attack?");
                String defender = reader.nextLine();

                enemyCountry = board.getCountry(CountryName.valueOf(defender));

                // Check to make sure the current player is not attacking a country they own.
                if (!currentPlayer.equals(enemyCountry.getRuler())) {

                    // Check to see if the country being attacked is an adjacent country.
                    if (countryOwnAdj.contains(enemyCountry.getCountryName())) {

                        System.out.println("With how many army? " + countryOwn.getCountryName() + " has " + countryOwn.getArmyOccupied() + " and " + enemyCountry.getCountryName() + " has " + enemyCountry.getArmyOccupied());
                        numAtkArmy = reader.nextInt();

                        // Check if the country being attack has zero army
                        // If so then takeover the country without commencing battlephase
                        if (enemyCountry.getArmyOccupied() == 0) {
                            enemyCountry.setRuler(currentPlayer);
                            currentPlayer.addNewCountry(enemyCountry);
                            enemyCountry.setArmyOccupied(numAtkArmy);
                            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);
                        }

                        // Check to see if the current player has the military force to attack.
                        else if (numAtkArmy <= countryOwn.getArmyOccupied() && numAtkArmy <= 3 && numAtkArmy != 0) {

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
     *
     * todo: Fareen refactor.
     */
    private void battlePhase() {

        // An array to store dice.
        Integer[] atkList = new Integer[3];
        Integer[] defList = new Integer[2];

        die = new Dice();

        // Fill up the array with the values of the dice.
        for (int i = 0; i < Math.min(numAtkArmy, countryOwn.getArmyOccupied()); i++) {

            die.rollDice();
            atkList[i] = die.getValue();
            System.out.println(currentPlayer.getName() + " Dice: " + (i + 1) +  " Value: " + atkList[i]);
            System.out.println();

        }

        for (int i = 0; i < Math.min(defList.length, enemyCountry.getArmyOccupied()); i++) {

            die.rollDice();
            defList[i] = die.getValue();
            System.out.println(enemyCountry.getRuler().getName() + " Dice: " + (i + 1) + " Value: " + defList[i]);
            System.out.println();

        }

        int numDefArmy = Math.min(defList.length, enemyCountry.getArmyOccupied());

        // Arrange the dice value in descending order.
        if (numAtkArmy > 1 && atkList[0] < atkList[1] || atkList[0] < atkList[2]) { //null pointer exception
            Arrays.sort(atkList, Collections.reverseOrder());
        }
        else {

        }
        if (numDefArmy > 1 && defList[0] < defList[1]) {
            Arrays.sort(defList, Collections.reverseOrder());
        }

        System.out.println(Arrays.toString(atkList)); // checking
        System.out.println(Arrays.toString(defList));

        // Compare the values from the attacker side and defender side
        if (atkList[0] > defList[0]) {
            enemyCountry.getRuler().setArmyCount(enemyCountry.getRuler().getArmyCount() - 1); // sub an army from enemy player
            enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - 1); // sub an army from enemy country
            numDefArmy--;
        }

        else {
            currentPlayer.setArmyCount(currentPlayer.getArmyCount() - 1); // sub an army from current player
            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - 1); // sub an army from current country
            numAtkArmy--;
        }

        if (atkList[1] != null && defList[1] != null){

            if (atkList[1] > defList[1]) {
                enemyCountry.getRuler().setArmyCount(enemyCountry.getRuler().getArmyCount() - 1);
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

            countryOwn.setRuler(enemyCountry.getRuler()); // Set the new Ruler
            enemyCountry.getRuler().addNewCountry(countryOwn); // Add the country to the new Ruler
            countryOwn.setArmyOccupied(numDefArmy); // put the army that was fighting in the new country
            enemyCountry.setArmyOccupied(enemyCountry.getArmyOccupied() - numDefArmy); // sub the num of army that was fighting

            // If the the current player total army count falls to zero, remove player from game.
            if (currentPlayer.getArmyCount() == 0) {
                removePlayer(currentPlayer);
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has lost " + countryOwn.getCountryName() + " to " + enemyCountry.getRuler().getName() + ".");

        }

        // If there are no more troops in the country, player takes over the country.
        if (enemyCountry.getArmyOccupied() == 0) {

            enemyCountry.setRuler(currentPlayer);
            currentPlayer.addNewCountry(enemyCountry);
            enemyCountry.setArmyOccupied(numAtkArmy); // Should check to make sure at least one army in countryOwn
            countryOwn.setArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);

            // If the enemy total army count falls to zero, remove player from game.
            if (enemyCountry.getRuler().getArmyCount() == 0) {
                removePlayer(enemyCountry.getRuler());
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has won " + enemyCountry.getCountryName() + " from " + enemyCountry.getRuler().getName() + ".");


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

    public static void main (String[] args){
        Game game = new Game();
        game.play();
    }
}
