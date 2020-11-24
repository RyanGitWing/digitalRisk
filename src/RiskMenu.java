import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Risk Menu Section.
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 */

public class RiskMenu extends JMenuBar implements ActionListener
{
    private final JMenuItem quitGame;
    private final JMenuItem saveGame;
    private final JMenuItem loadGame;
    private final JMenuItem help;

    /**
     * Create a menu object.
     */
    public RiskMenu () {

        //A game menu for menu bar
        JMenu aMenu = new JMenu("File");
        this.add(aMenu);

        //A load game item for menu (for M4)
        loadGame = new JMenuItem("Load Game");
        aMenu.add(loadGame);

        //A save game item for menu (for M4)
        saveGame = new JMenuItem("Save");
        aMenu.add(saveGame);

        //A quit game item for menu
        quitGame = new JMenuItem("Quit");
        quitGame.addActionListener(this);
        aMenu.add(quitGame);

        //A help item that display what the player can do
        help = new JMenuItem("Help");
        help.addActionListener(this);
        aMenu.add(help);

        this.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(quitGame))
        {
            System.exit(0);
        }
        if (e.getSource().equals(help))
        {
            String s = "To attack, select a country you own, a country to attack, and the number of troop. \n";
            s += "Game Status: Display the current state of the game. \n";
            s += "End Turn: End your turn. \n";
            JOptionPane.showMessageDialog(null, s, "Help!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
