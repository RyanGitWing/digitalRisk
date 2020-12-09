import javax.swing.*;
import java.awt.*;

/**
 * The JPanel containing the WorldMap GUI.
 *
 * @author Vis. K
 * @version 11.11.2020
 *
 * @author Vyasan. J
 * @version 11.22.2020
 *
 * @author Vis. K
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */

public class RiskMapGUI extends JPanel
{
    private final RiskController riskCtrl;

    /**
     *  This panel displays the WorldMap to the user.
     * */
    public RiskMapGUI (Game riskGame)
    {
        riskCtrl = new RiskController(riskGame);
        Board worldMap = riskGame.getBoardMap();

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.blue);
        this.setPreferredSize (new Dimension(1500,1000));

        for (Continent c:  worldMap.getBoardMap().values())
        {
            JPanel jPanel = continentPanel(c);
            if (c.getName().equals("NorthAmerica"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName().equals("SouthAmerica"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.anchor = GridBagConstraints.CENTER; // Change to LAST_LINE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName().equals("Europe"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.PAGE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName().equals("Africa"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 1;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(jPanel, constraints);
            }
            if (c.getName().equals("Asia"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_END;
                this.add(jPanel, constraints);
            }
            if (c.getName().equals("Australia"))
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.LAST_LINE_END;
                this.add(jPanel, constraints);
            }
        }
        this.setVisible(true);
    }

    /**
     * This is a helper method for WorldMapGUI() which sets up a JPanel corresponding to its respective continent
     * that is filled with Country JButtons
     * */
    public JPanel continentPanel (Continent continent)
    {
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.setBackground(Color.BLUE);
        for (Country country: continent.getCountries())
        {
            JButton jButton = new JButton(country.getCountryName().toString());
            jButton.setActionCommand(country.getCountryName().toString());
            if (country.getArmyOccupied() > 1) jButton.addActionListener(riskCtrl);
            jButton.setBackground(Color.black);

            // Handles colours based on ruler of country, white for neutral country owned by no one.
            if (country.getRuler().getName().equals("Player1")) {
                jButton.setForeground(Color.RED);
            }
            if (country.getRuler().getName().equals("Player2")||country.getRuler().getName().equals("AIPlayer2")) {
                jButton.setForeground(Color.ORANGE);
            }
            if (country.getRuler().getName().equals("Player3")||country.getRuler().getName().equals("AIPlayer3")) {
                jButton.setForeground(Color.YELLOW);
            }
            if (country.getRuler().getName().equals("Player4")||country.getRuler().getName().equals("AIPlayer4")) {
                jButton.setForeground(Color.GREEN);
            }
            if (country.getRuler().getName().equals("Player5")||country.getRuler().getName().equals("AIPlayer5")){
                jButton.setForeground(Color.CYAN);
            }
            if (country.getRuler().getName().equals("Player6")||country.getRuler().getName().equals("AIPlayer6")) {
                jButton.setForeground(Color.MAGENTA);
            }
            if (country.getRuler() == null) {
                jButton.setForeground(Color.white );
            }

            if (continent.getName().equals("NorthAmerica"))
            {
                if (country.getCountryName().equals("Alaska"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 0;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("NorthwestTerritories"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("WesternCanada"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("CentralCanada"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("EasternCanada"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("WesternUS"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("EasternUS"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("CentralAmerica"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 6;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Greenland"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName().equals("SouthAmerica"))
            {
                if (country.getCountryName().equals("Venezuela"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 7;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Peru"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 8;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Brazil"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 8;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Argentina"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 9;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName().equals("Europe"))
            {
                if (country.getCountryName().equals("Iceland"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("GreatBritain"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Scandinavia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Ukraine"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("NorthernEurope"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("SouthernEurope"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("WesternEurope"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName().equals("Africa"))
            {
                if (country.getCountryName().equals("NorthAfrica"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Egypt"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("EastAfrica"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Congo"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("SouthAfrica"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Madagascar"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 10;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName().equals("Asia"))
            {
                if (country.getCountryName().equals("Ural"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Afghanistan"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("MiddleEast"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }

                if (country.getCountryName().equals("Siberia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 7;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Yakutsk"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Kamchatka"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 9;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Irkutsk"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Mongolia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 9;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("China"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("India"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 7;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Siam"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("Japan"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 10;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName().equals("Australia"))
            {
                if (country.getCountryName().equals("Indonesia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 16;
                    constraints.gridy = 5;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("NewGuinea"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 17;
                    constraints.gridy = 6;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("WesternAustralia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 16;
                    constraints.gridy = 10;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName().equals("EasternAustralia"))
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 17;
                    constraints.gridy = 10;
                    jPanel.add(jButton, constraints);
                }
            }
        }
        return jPanel;
    }
}
