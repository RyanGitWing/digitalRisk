import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The JPanel containing the Commands Section.
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 *
 * @author Vyasan. J
 * @version 11.22.2020
 *
 * @author Vyasan. J
 * @version 11.23.2020
 *
 * @author Vis. K
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 */

public class CommandPanel extends JPanel implements ActionListener
{
    private final JButton nTurn;
    private final Game riskGame;

    /**
     * This panel holds all the commands the player can use.
     */
    public CommandPanel (Game riskGame)
    {
        this.riskGame = riskGame;

        //Create the panel to store the buttons and the Dice
        this.setPreferredSize(new Dimension(300, 0));
        this.setBackground(Color.green);

        //Make the end turn button
        nTurn = new JButton("End Turn");
        nTurn.addActionListener(this);

        //A box to store the buttons inside
        Box box = Box.createVerticalBox();

        //Adding end turn to the box, aligning it
        box.add(nTurn);
        nTurn.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding the box to the panel
        this.add(box);
    }

    /**
     * An action performed event handler.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nTurn))
        {
            riskGame.nextPlayer();
            riskGame.update();

            // call reinforcement/bonus army method. - returns an int
            int reinforce = riskGame.getBoardMap().getBonusArmy(riskGame.getCurrentPlayer()); // tot bonus army
            List<Country> currPlyrCountries = riskGame.getCurrentPlayer().getOwnedCountries();
            String [] CPlyrC = new String[currPlyrCountries.size()];
            for (int i = 0; i < CPlyrC.length; i++)
            {
                CPlyrC[i] = currPlyrCountries.get(i).getCountryName().toString() + " " + currPlyrCountries.get(i).getArmyOccupied();
            }

            if ((!riskGame.getCurrentPlayer().isAI())) JOptionPane.showMessageDialog(null, "You have received " + reinforce + " bonus army.", "Bonus Army!", JOptionPane.WARNING_MESSAGE);

            // army bonus/reinforcement placement for Human
            while (reinforce != 0 && (!riskGame.getCurrentPlayer().isAI())) {
                String bonusCountry = (String) JOptionPane.showInputDialog(null,
                        "Choose which country will receive your bonus army", "List of Owned Countries",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        CPlyrC, "");
                String[] army = new String[reinforce];
                for (int i = 0; i < army.length; i++) {
                    army[i] = String.valueOf(i+1);
                }
                if (bonusCountry != null) {
                    String armyB = (String) JOptionPane.showInputDialog(null,
                            "Choose how much army to place:", "Available Bonus: " + reinforce,
                            JOptionPane.INFORMATION_MESSAGE, null,
                            army, "");
                    if (armyB != null)
                    {
                        String bonusC = bonusCountry.substring(0,bonusCountry.indexOf(" "));
                        riskGame.getBoardMap().getCountry(bonusC).setArmyOccupied(riskGame.getBoardMap().getCountry(bonusC).getArmyOccupied() + Integer.parseInt(armyB));
                        reinforce -= Integer.parseInt(armyB);
                    }
                }
                riskGame.update();
            }
            if(riskGame.getCurrentPlayer().isAI()) {
                AIPlayer ai = (AIPlayer) riskGame.getCurrentPlayer();
                ai.aiDeploy(riskGame);
                ai.aiAttack(riskGame);
                riskGame.nextPlayer();
                riskGame.update();
            }
        }
    }
}
