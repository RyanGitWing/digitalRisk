import javax.swing.*;
import java.awt.*;

/**
 * The main Risk Frame containing all GUI elements.
 *
 * @author Vis. K
 * @version 11.09.2020
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 *
 */

public class RiskFrame extends JFrame implements RiskView{

    private Game riskGame;
    private RiskMapGUI  mapGUI;
    private final RiskNews riskNews;

    /**
     * Creates a RiskFrame object.
     */
    public RiskFrame(int numHumanPlayers,int numAIPlayers)
    {
        riskGame = new Game(numHumanPlayers,numAIPlayers);
        riskGame.addRiskView(this);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(2000,1000)); // changed width from 1500 to 2000
        this.pack();

        //Centering the frame to be in the middle of the screen
        this.setLocationRelativeTo(null);

        //Add the menu to the frame
        RiskMenu menu = new RiskMenu();
        this.setJMenuBar(menu);

        //Add the text panel to the frame
        String status = riskGame._getGameStatus();
        riskNews = new RiskNews(status);
        this.add(riskNews, BorderLayout.SOUTH);

        //Add the commands to the frame
        CommandPanel commandPanel = new CommandPanel(riskGame);
        this.add(commandPanel, BorderLayout.WEST);

        // Add the map to the frame
        mapGUI = new RiskMapGUI(riskGame);
        this.add(mapGUI, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Updates the main frame holding all of the GUI elements accordingly to progress in the Game.
     */
    @Override
    public void handleGameUpdate(RiskEvent e) {
        riskGame = (Game) e.getSource();
        this.remove(mapGUI);
        mapGUI = new RiskMapGUI(riskGame);
        this.add(mapGUI, BorderLayout.CENTER);
        this.revalidate();
        riskNews.updateNews(e.getStatus());
    }
}
