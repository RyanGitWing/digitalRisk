import java.util.EventObject;

/**
 * Event class for Risk game.
 *
 * @author Vis K
 * @version 11.11.2020
 *
 * @author Vis K
 * @version 11.23.2020
 * */

public class RiskEvent extends EventObject {

    /**
     * Creates a RiskEvent object.
     * @param game The game object.
     */
    public RiskEvent (Game game)
    {
        super(game);
    }

}
