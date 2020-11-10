import java.util.EventObject;

/**
 * Event class for Risk game.
 *
 * todo
 *
 * @author Vis K
 * @version 11.09.2020
 * */
public class RiskEvent extends EventObject {

    private  Board board;
    private String status;

    /**
     * Creates a RiskEvent object.
     * @param game The game object.
     * @param board The board containing the World Map.
     * @param status The status of the game.
     */
    public RiskEvent (Game game,Board board, String status)
    {
        super(game);
        this.board = board;
        this.status = status;
    }
}
