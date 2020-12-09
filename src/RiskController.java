import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Risk game.
 *
 * @author Vis. K
 * @version 11.11.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 */

public class RiskController implements ActionListener{

    private final Game riskGame;
    private final Board board;
    private FortifyController frt;
    private AtkController atk;

    /**
     * Creates a RiskController object.
     * @param riskGame The game object.
     */
    public RiskController(Game riskGame) {
        this.riskGame = riskGame;
        board = riskGame.getBoardMap();
        atk = new AtkController(riskGame);
        frt = new FortifyController(riskGame);
    }

    /**
     * Handles user interaction with WorldMapGUI and the phase of attacking countries.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object[] options = {"Attack", "Fortify"};

        int n = JOptionPane.showOptionDialog(null, "Attack or Fortify?", "Risk Action Phase",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (n == JOptionPane.YES_OPTION){
            atk.actionPerformed(e);
        }

        if (n == JOptionPane.NO_OPTION){
            frt.actionPerformed(e);
        }

    }
}