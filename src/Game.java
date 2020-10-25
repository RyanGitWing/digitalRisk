import java.util.*;

public class Game
{
    private Parser parser;

    private Dice die;

    private ArrayList<Player> playerList;

    private int numPlayers;

    private int playerIndex;

    private WorldMap map;

    private boolean hasAtk;

    private Player currentPlayer;

    private int numAtkArmy;

    private Country countryOwn, enemyCountry;



    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        playerList = new ArrayList<>();
        map = new WorldMap();
    }

    /**
     * Get a number of player between 2 and 6 from the user input for the
     * game to start.
     * @return the number of player.
     */
    public int retrievePlayers()
    {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number of players between 2 and 6: ");
        numPlayers = reader.nextInt();

        // If the number of players is less than 2 then request a larger amount.
        if (numPlayers < 2) {
            System.out.println("Not enough players!");
            retrievePlayers();
        }

        // If the number of players exceeds 6 request a different number of player
        else if (numPlayers > 6) {
            System.out.println("Too many players!");
            retrievePlayers();
        }

        // Insert players in a list.
        else {
            playerList = new ArrayList<>();

            for (int i = 0; i < numPlayers; i++) {
                playerList.add(new Player()); // Needs adjustment!!!
            }

            // Initialize the starting player.
            playerIndex = 0;
            currentPlayer = playerList.get(playerIndex);

        }

        return numPlayers;

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        retrievePlayers();

        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Method which returns the state of the game.
     * The number of armies and countries own by each player.
     *
     * @return The status of each player.
     */
    private void getGameStatus()
    {
        System.out.println("The current state of the world is: ");

        for (Player p : playerList){
            System.out.println("Player "+ p.getName() + " owns " + p.getCountryCount() + " countries and " + p.getArmyCount() + " armies.");
        }

        for (Country c : map) {
            System.out.println(c.getName() + " is ruled by Player " + c.getRuler().getName() + " with " + c.getArmyOccupied() + " armies.");
        }

        System.out.println("It's currently Player " + currentPlayer.getName() + " turn.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Risk!");
        System.out.println("Risk is a turn-based world domination game.");
        getGameStatus();
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }

        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        else if (commandWord.equals("status")) {
            status(command);
        }

        else if (commandWord.equals("attack")) {
            attackCMD(command);
        }

        else if (commandWord.equals("endturn")) {
            nextPlayer(command);
        }

        return wantToQuit;
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("Your command words are:");
        System.out.println("quit help status attack endturn");
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * "Status" was entered. Check the rest of the command to see
     * whether we checking the status of the game or not.
     * @param command The command to be processed.
     */
    private void status(Command command) {

        if(command.hasSecondWord()) {
            System.out.println("Status what?");

        }

        getGameStatus();

    }

    /**
     * "Attack" was entered. Check the rest of the command to see
     * where we attacking with how many troops.
     * @param command The command to be processed.
     */
    private void attackCMD(Command command) {

        if (command.hasSecondWord()) {
            System.out.println("Attack what?");

        }

        Scanner reader = new Scanner(System.in);

        System.out.println("Which country is attacking?");

        String attacker = reader.nextLine();
        countryOwn = map.getCountry(attacker);

        // Check to see if the current player owns this country.
        if(currentPlayer.equals(countryOwn.getRuler())) {

            System.out.println("Which country do you want to attack?");

            String defender = reader.nextLine();
            enemyCountry = map.getCountry(defender);

            // Check to make sure the current player is not attacking a country they own.
            if (!currentPlayer.equals(enemyCountry.getRuler())) {

                // Check to see if the country being attacked is an adjacent country.
                if (defender.equals(countryOwn.getAdjCountries(countryOwn))) {

                    System.out.println("With how many army?");

                    numAtkArmy = reader.nextInt();

                    // Check to see if the current player has the military force to attack.
                    if (numAtkArmy <= countryOwn.getArmyOccupied() && 3) {

                        battlePhase();

                    } else {
                        System.out.println("You do not own this many troops for " + attacker + ".");
                    }

                } else {
                    System.out.println(defender + "is not adjacent to " + attacker + ".");
                }

            } else {
                System.out.println("You own this country stupid!!!");
            }

        } else {
            System.out.println("You do not own this country.");
        }

    }

    /**
     * This method handles the battle phase between players. By rolling a
     * die based on the number of troops deployed.
     */
    private void battlePhase() {

        // An array to store dice.
        int[] atkList = new int[3];
        int[] defList = new int[2];

        die = new Dice();

        // Check to see if current player has attacked.
        if (hasAtk == false) {

            // Fill up the array with the values of the dice.
            for (int i = 0; i < numAtkArmy; i++) {
                die.rollDice();
                atkList[i] = die.getValue();
            }

            for (int i = 0; i < Math.min(defList.length, enemyCountry.getArmyOccupied()); i++) {
                die.rollDice();
                defList[i] = die.getValue();
            }

            // Arrange the dice value in ascending order.
            Arrays.sort(atkList);
            Arrays.sort(defList);

            // Compare the values from the attacker side and defender side
            // until one has reached zero.
            while (atkList[0] != 0 || defList[0] != 0) {

                if (atkList[0] > defList[0]) {

                    enemyCountry.getArmyOccupied()--;
                    defList[0] = defList[1];
                    defList[1] = 0;

                }

                if (atkList[0] < defList[0]){

                    countryOwn.getArmyOccupied()--;
                    numAtkArmy--;
                    atkList[0] = atkList[1];
                    atkList[1] = atkList[2];
                    atkList[2] = 0;

                }

                if (atkList[0] == defList[0]){

                    int temp = atkList[0];
                    atkList[0] = atkList[2];
                    atkList[2] = temp;

                }

            }

            // If there are no more troops in the country, player takes over the country.
            if (countryOwn.getArmyOccupied() == 0) {

                // If the the current player total army count falls to zero, remove player from game.
                if (currentPlayer.getArmyCount() == 0) {
                    removePlayer(currentPlayer);
                }

                System.out.println("NEWS: Player " + currentPlayer.getName() + " has lost " + countryOwn.getName() + " to " + enemyCountry.getRuler().getName() + ".");
                currentPlayer.TurnLost(countryOwn);
            }

            // If there are no more troops in the country, player takes over the country.
            if (enemyCountry.getArmyOccupied() == 0) {

                // If the enemy total army count falls to zero, remove player from game.
                if (enemyCountry.getRuler().getArmyCount() == 0) {
                    removePlayer(enemyCountry.getRuler());
                }

                System.out.println("NEWS: Player " + currentPlayer.getName() + " has won " + enemyCountry.getName() + " from " + enemyCountry.getRuler().getName() + ".");
                currentPlayer.TurnWon(countryOwn, numAtkArmy, enemyCountry);

            }

            hasAtk = true;

        }

    }

    /**
     * Remove the player who has no more army from the game.
     *
     * @param dead The player to remove from the game
     */
    private void removePlayer(Player dead){

        System.out.println("NEWS: Player " + dead + " has been eliminated from the game!");

        playerList.remove(dead);

    }


    /**
     * "endturn" was entered. Check the rest of the command to see
     * whether we really want to pass our turn to the following player.
     * @param command The command to be processed.
     */
    private void nextPlayer(Command command) {

        if(command.hasSecondWord()) {
            System.out.println("End turn what?");
        }

        playerIndex++;

        // If the index is bigger or equal to the player list go back to index 0
        if (playerIndex >= playerList.size()){
            playerIndex = 0;

        }

        // Player that is playing according to index.
        currentPlayer = playerList.get(playerIndex);
        hasAtk = false;
        getGameStatus();


    }

    public static void main (String[] args){
        Game game = new Game();
        game.play();
    }
}
