import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The Risk Deploy Controller.
 *
 * @author Vis. K
 * @version 12.09.2020
 */

public class DeployController implements  ActionListener
{
    private final Game riskGame;
    private final Board board;

    /**
     * Creates a RiskController object.
     *
     * @param riskGame The game object.
     */
    public DeployController(Game riskGame) {
        this.riskGame = riskGame;
        this.board = riskGame.getBoardMap();
    }

    /**
     * Event handler for deploying troops.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String bonusC = e.getActionCommand();
        Country bonusCountry = board.getCountry(bonusC);
        if (!riskGame.getCurrentPlayer().equals(bonusCountry.getRuler())){
            String text = "";
            text += "You don't own this country. ";
            JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else {
            // call reinforcement/bonus army method. - returns an int
            List<Country> currPlyrCountries = riskGame.getCurrentPlayer().getOwnedCountries();
            String [] CPlyrC = new String[currPlyrCountries.size()];
            for (int i = 0; i < CPlyrC.length; i++)
            {
                CPlyrC[i] = currPlyrCountries.get(i).getCountryName() + " " + currPlyrCountries.get(i).getArmyOccupied();
            }

            if ((!riskGame.getCurrentPlayer().isAI())) JOptionPane.showMessageDialog(null, "You have received " + riskGame.getReinforce() + " bonus army.", "Bonus Army!", JOptionPane.WARNING_MESSAGE);

            // army bonus/reinforcement placement for Human
            while (riskGame.getReinforce()!= 0 && (!riskGame.getCurrentPlayer().isAI()) && riskGame.getState() == Game.State.Deploy) {
                String[] army = new String[riskGame.getReinforce()];
                for (int i = 0; i < army.length; i++) {
                    army[i] = String.valueOf(i+1);
                }
                if (bonusCountry != null) {
                    String armyB = (String) JOptionPane.showInputDialog(null,
                            "Choose how much army to place:", "Available Bonus: " + riskGame.getReinforce(),
                            JOptionPane.INFORMATION_MESSAGE, null,
                            army, "");
                    if (armyB != null)
                    {
                        riskGame.deployCMD(bonusC, Integer.parseInt(armyB));
                        riskGame.update();
                    }
                }
            }
        }
    }
}
