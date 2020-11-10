import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the Risk game.
 */
public class RiskController  implements ActionListener {

    private Game riskGame;

    /**
     * Creates a RiskContoller object.
     * @param riskGame The game object.
     */
    public RiskController(Game riskGame) {
        this.riskGame = riskGame;
    }

    /**
     * Action performed event.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}