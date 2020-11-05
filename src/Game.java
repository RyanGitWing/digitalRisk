import java.util.*;

/**
 * Risk Game, a turn-based world domination game where players take turn fighting each other to the death until only
 * one player remain conquering the whole world.
 *
 * @author Ryan Nguyen
 * @version 10.25.2020
 */
public class Game
{
    private Parser parser;

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



    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        playerList = new ArrayList<>();
        wMap = new WorldMap();
        contMap = new ContinentMap();
        cMap = new CountryMap();
        hasAtk = false;
    }

    /**
     * Get a number of player between 2 and 6 from the user input for the
     * game to start.
     */
    public void retrievePlayers()
    {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number of players between 2 and 6: ");
        numPlayers = reader.nextInt();


        // If the number of players is less than 2 then request a larger amount.
        if (numPlayers < 2) { //todo
            System.out.println("Not enough players!");
            retrievePlayers();
            return;
        }

        // If the number of players exceeds 6 request a different number of player
        else if (numPlayers > 6) {
            System.out.println("Too many players!");
            retrievePlayers();
            return;
        }

        // Insert players in a list.
        else { //todo
            playerList = new ArrayList<>();

            for (int i = 0; i < numPlayers; i++) {

                playerList.add(new Player("Player" + (i + 1)));

            }

            // Initialize the starting player.
            playerIndex = 0;
            currentPlayer = playerList.get(playerIndex);

        }
        wMap.randAlloc(numPlayers, playerList);

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
     */
    private void getGameStatus()
    {
        System.out.println("The current state of the world is: \n");

        for (Player p : playerList){
            System.out.println(p.getName() + " owns " + p.getOwnedCountries().size() + " countries and " + p.GetArmyCount() + " armies.");
        }

        System.out.println();
        for (Player p : playerList)
        {
            String ownedCountries = "";
            for (int i = 0; i < p.getOwnedCountries().size(); i++)
            {
                ownedCountries += p.getOwnedCountries().get(i).getName() + " ";
            }
            System.out.println (p.getName() + " owns the following countries: " + ownedCountries);
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
        System.out.println("Risk is a turn-based world domination game.");
        getGameStatus();
        System.out.println("Type 'help' if you need help. \n");
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
        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            case "status":
                status(command);
                break;
            case "attack":
                attackCMD(command);
                break;
            case "endturn":
                nextPlayer(command);
                break;
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
        if (!hasAtk) {

            Scanner reader = new Scanner(System.in);

            System.out.println("Which country is attacking?");
            String attacker = reader.nextLine();

            countryOwn = wMap.getCountry(CountryName.valueOf(attacker));

            List<CountryName> countryOwnAdj = countryOwn.getAdjCountries(countryOwn.getName());
            String countryAtkOpt = "";
            for (CountryName countryName : countryOwnAdj) {
                countryAtkOpt += countryName + " ";
            }
            System.out.println("The available countries to attack are: " + countryAtkOpt);

            // Check to see if the current player owns this country.
            if (currentPlayer.equals(countryOwn.getRuler())) {

                System.out.println("Which country do you want to attack?");
                String defender = reader.nextLine();

                enemyCountry = wMap.getCountry(CountryName.valueOf(defender));

                // Check to make sure the current player is not attacking a country they own.
                if (!currentPlayer.equals(enemyCountry.getRuler())) {

                    // Check to see if the country being attacked is an adjacent country.
                    if (countryOwnAdj.contains(enemyCountry.getName())) {

                        System.out.println("With how many army? " + countryOwn.getName() + " has " + countryOwn.getArmyOccupied() + " and " + enemyCountry.getName() + " has " + enemyCountry.getArmyOccupied());
                        numAtkArmy = reader.nextInt();

                        // Check if the country being attack has zero army
                        // If so then takeover the country without commencing battlephase
                        if (enemyCountry.getArmyOccupied() == 0) {
                            enemyCountry.setRuler(currentPlayer);
                            currentPlayer.addNewCountry(enemyCountry);
                            enemyCountry.addArmyOccupied(numAtkArmy);
                            countryOwn.addArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);
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
            enemyCountry.getRuler().SetArmyCount(enemyCountry.getRuler().GetArmyCount() - 1); // sub an army from enemy player
            enemyCountry.addArmyOccupied(enemyCountry.getArmyOccupied() - 1); // sub an army from enemy country
            numDefArmy--;
        }

        else {
            currentPlayer.SetArmyCount(currentPlayer.GetArmyCount() - 1); // sub an army from current player
            countryOwn.addArmyOccupied(countryOwn.getArmyOccupied() - 1); // sub an army from current country
            numAtkArmy--;
        }

        if (atkList[1] != null && defList[1] != null){

            if (atkList[1] > defList[1]) {
                enemyCountry.getRuler().SetArmyCount(enemyCountry.getRuler().GetArmyCount() - 1);
                enemyCountry.addArmyOccupied(enemyCountry.getArmyOccupied() - 1);
                numDefArmy--;
            }

            else {
                currentPlayer.SetArmyCount(currentPlayer.GetArmyCount() - 1);
                countryOwn.addArmyOccupied(countryOwn.getArmyOccupied() - 1);
                numAtkArmy--;
            }

        }

        // If there are no more troops in the country, player takes over the country.
        if (countryOwn.getArmyOccupied() == 0) {

            countryOwn.setRuler(enemyCountry.getRuler()); // Set the new Ruler
            enemyCountry.getRuler().addNewCountry(countryOwn); // Add the country to the new Ruler
            countryOwn.addArmyOccupied(numDefArmy); // put the army that was fighting in the new country
            enemyCountry.addArmyOccupied(enemyCountry.getArmyOccupied() - numDefArmy); // sub the num of army that was fighting

            // If the the current player total army count falls to zero, remove player from game.
            if (currentPlayer.GetArmyCount() == 0) {
                removePlayer(currentPlayer);
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has lost " + countryOwn.getName() + " to " + enemyCountry.getRuler().getName() + ".");
            // currentPlayer.TurnLost(countryOwn);
        }

        // If there are no more troops in the country, player takes over the country.
        if (enemyCountry.getArmyOccupied() == 0) {

            enemyCountry.setRuler(currentPlayer);
            currentPlayer.addNewCountry(enemyCountry);
            enemyCountry.addArmyOccupied(numAtkArmy); // Should check to make sure at least one army in countryOwn
            countryOwn.addArmyOccupied(countryOwn.getArmyOccupied() - numAtkArmy);

            // If the enemy total army count falls to zero, remove player from game.
            if (enemyCountry.getRuler().GetArmyCount() == 0) {
                removePlayer(enemyCountry.getRuler());
            }

            System.out.println("NEWS: " + currentPlayer.getName() + " has won " + enemyCountry.getName() + " from " + enemyCountry.getRuler().getName() + ".");
            //currentPlayer.TurnWon(countryOwn, numAtkArmy, enemyCountry);//todo

        }

        hasAtk = true;

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

    public static void main (String[] args){
        Game game = new Game();
        game.play();
    }
}