import java.util.EventObject;

/**
 * @author : Vis K
 * //todo
 * */
public class RiskEvent extends EventObject {

    private  Board board;
    private String status;

    public RiskEvent (Game game,Board board, String status)
    {
        super(game);
        this.board = board;
        this.status = status;
    }
}
