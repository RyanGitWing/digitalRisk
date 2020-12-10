import java.io.Serializable;
import java.util.*;

/**
 * This class is a to help save the state of the game.
 *
 * @author Ryan. N
 * @version 12.09.2020
 */

public class GameState implements Serializable {

    ArrayList<Player> players;
    int totalPlayers;
    int humanPlayers;
    int AIPlayers;
    int playerIndex;
    Board board;
    Player currentPlayer;

    /**
     * Create GameState object.
     *
     * @param pL The player list.
     * @param tP The total number of players.
     * @param hP The number of human players.
     * @param aI The number of AI players.
     * @param pI The player index.
     * @param b The board of the game.
     * @param c The current player.
     */
    public GameState(ArrayList<Player> pL, int tP, int hP, int aI, int pI, Board b, Player c) {

        players = pL;
        totalPlayers = tP;
        humanPlayers = hP;
        AIPlayers = aI;
        playerIndex = pI;
        board = b;
        currentPlayer = c;

    }

    /**
     * Returns the player list.
     *
     * @return The list of players.
     */
    public ArrayList<Player> getPL(){
        return players;
    }

    /**
     * Returns the total number of players.
     *
     * @return The total number of players.
     */
    public int getTP(){
        return totalPlayers;
    }

    /**
     * Returns the number of human players.
     *
     * @return The number of human players.
     */
    public int getHP(){
        return humanPlayers;
    }

    /**
     * Returns the number of AI players
     *
     * @return The number of AI players.
     */
    public int getAI(){
        return AIPlayers;
    }

    /**
     * Returns the current player index.
     *
     * @return The player index.
     */
    public int getPI(){
        return playerIndex;
    }

    /**
     * Returns the board of the game.
     *
     * @return The board.
     */
    public Board getB(){
        return board;
    }

    /**
     * Returns the current player.
     *
     * @return The current player.
     */
    public Player getC(){
        return currentPlayer;
    }
}
