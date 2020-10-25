import java.util.*;

/**
 * Author: Ryan Nguyen
 */
public class Game
{
    private Parser parser;

<<<<<<< Updated upstream
=======
    private Dice die;

    private ArrayList<Player> playerList;

    private int numPlayers;

    private int playerIndex;

    private WorldMap wMap;

    private ContinentMap contMap;

    private CountryMap cMap;

    private boolean hasAtk;

    private Player currentPlayer;

    private int numAtkArmy;

    private Country countryOwn, enemyCountry;



>>>>>>> Stashed changes
    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
<<<<<<< Updated upstream
=======
        playerList = new ArrayList<>();
        wMap = new WorldMap();
        contMap = new ContinentMap();
        cMap = new CountryMap();
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

                playerList.add(new Player("Player" + (i + 1), null)); // todo

            }

            // Initialize the starting player.
            playerIndex = 0;
            currentPlayer = playerList.get(playerIndex);

        }

        return numPlayers;

>>>>>>> Stashed changes
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
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
     * Method which prints the status of the player.
     *
     * @param p The player we want information on
     */
    private void getPlayerStatus (Player p)
    {
        for (Continent c: wMap.getWorldMap().values())
        {
            for (int i = 0; i < wMap.getWorldMap().size();i++)
            {
                if (c.getContinent().get(i).getRuler() == p)
                {
                    System.out.println (c.getContinent().get(i).getName() + " is ruled by Player " + c.getContinent().get(i).getRuler() + " with " + c.getContinent().get(i).getArmyOccupied() + "armies");
                }
                if (c.getContinent().get(i).getRuler() == null) {
                    System.out.println(c.getContinent().get(i).getName() + " is ruled by no one ");
                    i++;
                }
            }
        }
    }

    /**
     * Method which returns the state of the game.
     * The number of armies and countries own by each player.
     *
     * @return The status of each player.
     */
    private void getGameStatus()
    {
        System.out.println("The current state of the world is: \n");

        for (Player p : playerList){
            System.out.println(p.getName() + " owns " + 0 + " countries and " + 0 + " armies."); // System.out.println(p.getName() + " owns " + p.GetCountryCount() + " countries and " + p.GetArmyCount() + " armies. \n"); todo
        }

        System.out.println();

         for (Player p : playerList) {
            getPlayerStatus(p);
         }

        System.out.println();

        System.out.println("It's currently " + currentPlayer.getName() + " turn. \n");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Risk!");
<<<<<<< Updated upstream
        System.out.println("Risk is a turn-based world domination game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printDescription();
        System.out.println();
=======
        System.out.println("Risk is a turn-based world domination game. \n");
        getGameStatus();
        System.out.println("Type 'help' if you need help. \n");
>>>>>>> Stashed changes
    }

    /**
     * This is the method would print the status of the game?
     */
    private void printDescription()
    {

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
<<<<<<< Updated upstream
            endTurn(command);
=======
            nextPlayer(command);
>>>>>>> Stashed changes
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

        System.out.println("From which continent is from?"); // Should check if the country is part of this continent. todo
        String continentAttacker = reader.nextLine();

        countryOwn = wMap.getCountry(ContinentName.valueOf(continentAttacker), CountryName.valueOf(attacker)); // adjusted according to getCountry method todo

        // Check to see if the current player owns this country.
        if(currentPlayer.equals(countryOwn.getRuler())) {

            System.out.println("Which country do you want to attack?");
            String defender = reader.nextLine();

            System.out.println("From which continent is from?"); // Should check if the country is part of this continent. todo
            String continentDefender = reader.nextLine();

<<<<<<< Updated upstream
=======
            enemyCountry = wMap.getCountry(ContinentName.valueOf(continentDefender), CountryName.valueOf(defender)); // adjusted according to getCountry method todo

            // Check to make sure the current player is not attacking a country they own.
            if (!currentPlayer.equals(enemyCountry.getRuler())) {

                // Check to see if the country being attacked is an adjacent country.
                if (defender.equals(countryOwn.getAdjCountries(CountryName.valueOf(attacker)))) { // change the internal of getAdj.. todo

                    System.out.println("With how many army?");

                    numAtkArmy = reader.nextInt();

                    // Check to see if the current player has the military force to attack.
                    if (numAtkArmy <= countryOwn.getArmyOccupied() && numAtkArmy <= 3) {

                        // Onto war!!!
                        battlePhase();

                    } else {
                        System.out.println("You do not own this many troops for " + attacker + ".");
                        System.out.println("Try attacking again or another cmd.");
                    }

                } else {
                    System.out.println(defender + "is not adjacent to " + attacker + ".");
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

                    enemyCountry.armyOccupied--; //enemyCountry.getArmyOccupied()--; todo
                    defList[0] = defList[1];
                    defList[1] = 0;

                }

                if (atkList[0] < defList[0]){

                    countryOwn.armyOccupied--; // Change from countryOwn.getArmyOccupied()--; todo
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
                if (currentPlayer.GetArmyCount() == 0) {
                    removePlayer(currentPlayer);
                }

                System.out.println("NEWS: " + currentPlayer.getName() + " has lost " + countryOwn.getName() + " to " + enemyCountry.getRuler().getName() + ".");
                currentPlayer.TurnLost(countryOwn);
            }

            // If there are no more troops in the country, player takes over the country.
            if (enemyCountry.getArmyOccupied() == 0) {

                // If the enemy total army count falls to zero, remove player from game.
                if (enemyCountry.getRuler().GetArmyCount() == 0) {
                    removePlayer(enemyCountry.getRuler());
                }

                System.out.println("NEWS: " + currentPlayer.getName() + " has won " + enemyCountry.getName() + " from " + enemyCountry.getRuler().getName() + ".");
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

        System.out.println("NEWS: " + dead + " has been eliminated from the game!");

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

>>>>>>> Stashed changes
    public static void main (String[] args){
        Game game = new Game();
        game.play();
    }
}
