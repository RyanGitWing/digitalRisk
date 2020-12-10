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
 * @author Vyasan. J
 * @version 11.22.2020
 *
 * @author Vyasan. J
 * @version 11.22.2020
 *
 * @author Vis. K
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 *
 * @author Vis.K
 * @version 12.09.2020
 */

public class RiskFrame extends JFrame implements RiskView{

    private Game riskGame;
    private RiskMapGUI  mapGUI;
    private LegendGUI legendGUI;

    /**
     * Creates a RiskFrame object.
     */
    public RiskFrame(int numHumanPlayers,int numAIPlayers, String mapPath)
    {
        riskGame = new Game(numHumanPlayers,numAIPlayers, mapPath);
        riskGame.addRiskView(this);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(2000,1000)); // changed width from 1500 to 2000
        this.pack();

        //Centering the frame to be in the middle of the screen
        this.setLocationRelativeTo(null);

        //Add the menu to the frame
        RiskMenu menu = new RiskMenu(riskGame);
        this.setJMenuBar(menu);

        //LegendGUI (Players and their colours in MapGUI);
        legendGUI = new LegendGUI(riskGame);
        this.add(legendGUI, BorderLayout.SOUTH);

        // Add the map to the frame
        mapGUI = new RiskMapGUI(riskGame);
        this.add(mapGUI, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Handles AI-Only match - since AIPlayer is current player, that means no Human player exists
        while(riskGame.getCurrentPlayer().isAI()) {
        int ownedSize = riskGame.getCurrentPlayer().getOwnedCountries().size();
        AIPlayer ai = (AIPlayer) riskGame.getCurrentPlayer();
        ai.aiDeploy(riskGame);
        riskGame.update();
        if(ownedSize>=7) {
            ai.aiAggroAttack(riskGame);
        }
        else{
            ai.aiPassiveAttack(riskGame);
        }
            riskGame.update();
            riskGame.nextPlayer();
        riskGame.update();
    }
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
        this.remove(legendGUI);
        legendGUI = new LegendGUI(riskGame);
        this.add(legendGUI, BorderLayout.SOUTH);
        this.revalidate();
    }
}
