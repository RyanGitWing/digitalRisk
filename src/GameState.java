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
     * This method returns the player list.
     *
     * @return
     */
    public ArrayList<Player> getPL(){
        return players;
    }

    /**
     * This method returns the total number of players.
     *
     * @return
     */
    public int getTP(){
        return totalPlayers;
    }

    /**
     * This method returns the number of human players.
     *
     * @return
     */
    public int getHP(){
        return humanPlayers;
    }

    /**
     * This method returns the number of AI players
     *
     * @return
     */
    public int getAI(){
        return AIPlayers;
    }

    /**
     * This method returns the player index.
     *
     * @return
     */
    public int getPI(){
        return playerIndex;
    }

    /**
     * This method returns the board.
     *
     * @return
     */
    public Board getB(){
        return board;
    }

    /**
     * This method returns the current player.
     *
     * @return
     */
    public Player getC(){
        return currentPlayer;
    }
}
