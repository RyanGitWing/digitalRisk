import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LegendGUI extends JPanel
{

    public LegendGUI (Game riskGame)
    {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.white);

        List <Player> playerList = riskGame.getPlayerList();

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
        this.setVisible(true);
    }

}
