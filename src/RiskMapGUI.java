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
            if (c.getName() == ContinentName.NorthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.SouthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.anchor = GridBagConstraints.CENTER; // Change to LAST_LINE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Europe)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.PAGE_START;
                this.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Africa)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 1;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.CENTER;
                this.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Asia)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_END;
                this.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Australia)
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
            JButton jButton = new JButton(country.getCountryName().toString() + ": " + country.getArmyOccupied());
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

            if (continent.getName() == ContinentName.NorthAmerica)
            {
                if (country.getCountryName() == CountryName.Alaska)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 0;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.NorthwestTerritories)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.WesternCanada)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.CentralCanada)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.EasternCanada)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.WesternUS)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.EasternUS)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.CentralAmerica)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 1;
                    constraints.gridy = 6;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Greenland)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName() == ContinentName.SouthAmerica)
            {
                if (country.getCountryName() == CountryName.Venezuela)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 7;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Peru)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 8;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Brazil)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 8;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Argentina)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 9;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName() == ContinentName.Europe)
            {
                if (country.getCountryName() == CountryName.Iceland)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 2;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.GreatBritain)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Scandinavia)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Ukraine)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.NorthernEurope)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.SouthernEurope)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.WesternEurope)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName() == ContinentName.Africa)
            {
                if (country.getCountryName() == CountryName.NorthAfrica)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Egypt)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.EastAfrica)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 5;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Congo)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 3;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.SouthAfrica)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 4;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Madagascar)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 10;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName() == ContinentName.Asia)
            {
                if (country.getCountryName() == CountryName.Ural)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Afghanistan)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.MiddleEast)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 3;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }

                if (country.getCountryName() == CountryName.Siberia)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 7;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Yakutsk)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Kamchatka)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 9;
                    constraints.gridy = 0;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Irkutsk)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 1;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Mongolia)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 9;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.China)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.India)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 7;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Siam)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 8;
                    constraints.gridy = 4;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.Japan)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 10;
                    constraints.gridy = 2;
                    jPanel.add(jButton, constraints);
                }
            }
            if (continent.getName() == ContinentName.Australia)
            {
                if (country.getCountryName() == CountryName.Indonesia)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 16;
                    constraints.gridy = 5;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.NewGuinea)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 17;
                    constraints.gridy = 6;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.WesternAustralia)
                {
                    GridBagConstraints constraints = new GridBagConstraints();
                    constraints.gridx = 16;
                    constraints.gridy = 10;
                    jPanel.add(jButton, constraints);
                }
                if (country.getCountryName() == CountryName.EasternAustralia)
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
