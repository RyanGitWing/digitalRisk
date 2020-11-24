import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 */

public class CommandPanel extends JPanel implements ActionListener
{
    private final JButton stat;
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

        //Make the status button
        stat = new JButton("Game Status");
        stat.addActionListener(this);

        //Make the end turn button
        nTurn = new JButton("End Turn");
        nTurn.addActionListener(this);

        //A box to store the buttons inside
        Box box = Box.createVerticalBox();

        //Adding status to the box, aligning it, and spacing it from the following button
        box.add(stat);
        box.add(Box.createVerticalStrut(250));
        stat.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding end turn to the box, aligning it
        box.add(nTurn);
        nTurn.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding the box to the panel
        this.add(box);

        //playerStatPanel.add(dice ,BorderLayout.SOUTH);
    }

    /**
     * An action performed event handler.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(stat))
        {
            riskGame.update();
        }
        if (e.getSource().equals(nTurn))
        {
            riskGame.nextPlayer();

            while(riskGame.getCurrentPlayer().isAI()){
                AIPlayer ai = (AIPlayer) riskGame.getCurrentPlayer();
                ai.aiDeploy(riskGame);
                ai.aiAttack(riskGame);
                riskGame.nextPlayer();
            }

            riskGame.update();
        }
    }
}
