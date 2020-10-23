import java.util.*;

public class Game
{
    private Parser parser;

    private ArrayList<Dice> diceValue;

    private Dice die;

    private LinkedList<Player> players;

    private int numPlayers;


    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        parser = new Parser();
        die = new Dice();
        players = new LinkedList<>();
    }

    public int retrievePlayers()
    {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter number of players: ");
        numPlayers = reader.nextInt();

        players = new LinkedList<>();

        for (int i = 0; i < numPlayers; i++){
            players.set(i, new Player(i+1));
        }

        return numPlayers;

    }

    private void createMap()
    {

        Map map = new Map();
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
        System.out.println("How many players are playing");
        System.out.println();
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
            endTurn(command);
        }

        else if (commandWord.equals("move")) {
            move(command);
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
            System.out.println("Attack with how many?");

        }

    }

    /**
     * "EndTurn" was entered. Check the rest of the command to see
     * whether we really ended our turn.
     * @param command The command to be processed.
     */
    private Boolean endTurn(Command command) {

        if(command.hasSecondWord()) {
            System.out.println("End turn what?");

        }
        return true;
    }

    private Boolean move(Command command) {

        if(!command.hasSecondWord()) {
            System.out.println("Move what?");
        }

        return false;
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
