import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * The JPanel containing the Legend GUI.
 *
 * @author Vis. K
 * @version 11.23.2020
 *
 */

public class LegendGUI extends JPanel implements ActionListener
{
    private final JButton nTurn;
    private final Game riskGame;

    /**
     * Creates a LegendGUI object.
     */
    public LegendGUI (Game riskGame)
    {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.white);
        this.riskGame = riskGame;

        List <Player> playerList = riskGame.getPlayerList();
        JButton [] buttons = new JButton[playerList.size()];
        for (Player p: playerList)
        {
            JButton button = new JButton(p.getName());
            button.setBackground(Color.black);
            if (p.getName().equals(riskGame.getCurrentPlayer().getName()))
            {
                button.setBackground(Color.BLUE); // changes colour based on who current player is
            }
            if (p.getName().equals("Player1") || p.getName().equals("AIPlayer1"))
            {
                button.setForeground(Color.RED);
            }
            if (p.getName().equals("Player2") || p.getName().equals("AIPlayer2"))
            {
                button.setForeground(Color.ORANGE);
            }
            if (p.getName().equals("Player3") || p.getName().equals("AIPlayer3"))
            {
                button.setForeground(Color.YELLOW);
            }
            if (p.getName().equals("Player4") || p.getName().equals("AIPlayer4"))
            {
                button.setForeground(Color.GREEN);
            }
            if (p.getName().equals("Player5") || p.getName().equals("AIPlayer5"))
            {
                button.setForeground(Color.CYAN);
            }
            if(p.getName().equals("Player6") || p.getName().equals("AIPlayer6"))
            {
                button.setForeground(Color.MAGENTA);
            }
            this.add(button);
        }

        JButton state = new JButton("Current State: " + riskGame.getState());
        state.setBackground(Color.black);
        state.setForeground(Color.white);
        this.add(state);

        //Make the end turn button
        nTurn = new JButton("End Turn");
        nTurn.addActionListener(this);
        this.add(nTurn);

        this.setVisible(true);
    }

    /**
     * An action performed event handler.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        riskGame.runAI();
        riskGame.update();
    }
}
