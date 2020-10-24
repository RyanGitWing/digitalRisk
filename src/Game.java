import java.util.*;

public class Game
{
    private Parser parser;

    private ArrayList<Dice> diceValue;

    private Dice die;

    private ArrayList<Player> playerList;

    private int numPlayers;

    private int playerIndex;

    private Map map;

    private Boolean hasAtk;

    private Player currentPlayer;


    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        die = new Dice();
        playerList = new ArrayList<>();
        map = new Map();
    }

    /**
     * Get a number of player between 2 and 6 from the user input for the
     * game to start.
     * @return the number of player.
     */
    public int retrievePlayers()
    {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter number of players: ");
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
                playerList.add(i, new Player()); // Needs adjustment!!!
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
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Risk!");
        System.out.println("Risk is a turn-based world domination game.");
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
            attack(command);
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

        if(command.hasSecondWord() || command.hasThirdWord() || command.hasFourthWord()) {
            System.out.println("Status what?");

        }

    }

    /**
     * "Attack" was entered. Check the rest of the command to see
     * where we attacking with how many troops.
     * @param command The command to be processed.
     */
    private void attack(Command command) {

        if(!command.hasSecondWord()) {
            System.out.println("Attack what?");

        }

        if(!command.hasThirdWord()) {
            System.out.println("Attack from where?");

        }

        if(!command.hasThirdWord()) {
            System.out.println("Attack with how many army?");

        }

        if (hasAtk == false) {



        }


        hasAtk = true;

    }

    /**
     * "endturn" was entered. Check the rest of the command to see
     * whether we really want to pass our turn to the following player.
     * @param command The command to be processed.
     */
    private void nextPlayer(Command command) {

        if(command.hasSecondWord() || command.hasThirdWord() || command.hasFourthWord()) {
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

        System.out.println("My turn!"); // For testing


    }

    /**
    public int fightPower(){

        ArrayList<Dice> atkList = new ArrayList<>(3);
        ArrayList<Dice> defList = new ArrayList<>(2);

        if (player.) {
            for (int i = 0; i < atkList.size(); i++) {
                die.rollDice();
                atkList.add(die);
            }
        }
        if (player is defending) {
            for (int i = 0; i < defList.size(); i++) {
                die.rollDice();
                defList.add(die);
            }
        }


    }
     */

    public static void main (String[] args){
        Game game = new Game();
        game.play();
    }
}
