import java.io.Serializable;
import java.util.*;

public class GameState implements Serializable {

    ArrayList<Player> players;
    int totalPlayers;
    int humanPlayers;
    int AIPlayers;
    int playerIndex;
    Board board;
    Player currentPlayer;
    List<RiskView> riskViews;
    public GameState(ArrayList<Player> pL, int tP, int hP, int aI, int pI, Board b, Player c) {

        players = pL;
        totalPlayers = tP;
        humanPlayers = hP;
        AIPlayers = aI;
        playerIndex = pI;
        board = b;
        currentPlayer = c;

    }

    public ArrayList<Player> getPL(){
        return players;
    }

    public int getTP(){
        return totalPlayers;
    }

    public int getHP(){
        return humanPlayers;
    }

    public int getAI(){
        return AIPlayers;
    }

    public int getPI(){
        return playerIndex;
    }

    public Board getB(){
        return board;
    }

    public Player getC(){
        return currentPlayer;
    }

    public List<RiskView> getRV(){
        return riskViews;
    }

}
