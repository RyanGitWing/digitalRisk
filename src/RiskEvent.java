import java.util.EventObject;

/**
 * @author : Vis K
 * //todo
 * */
public class RiskEvent extends EventObject {

    private  Board board;
    private int x;
    private int y;

    public RiskEvent (Game game,Board board)
    {
        super(game);
        this.board = board;
    }
}
