import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame implements View
{
    public Frame ()
    {
        super("Risk");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(2000,1000);
        Game g = new Game();
        g.addRiskView(this);
        Controller controller = new Controller(g);

        JPanel cd = new JPanel();
        JButton cmd = new JButton("CMD");
        cd.add(cmd, BorderLayout.WEST);
        cd.setPreferredSize(new Dimension(500,500));
        cd.setBackground(Color.pink);
        JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(500,500));
        test.setBackground(Color.YELLOW);
        JButton ct = new JButton("WORLD NEWS HERE");
        test.add(ct);

        // Setting up WorldMap GUI representation
        WorldMap worldMap = new WorldMap();
        JPanel map = new JPanel(new GridBagLayout());
        map.setBackground(Color.CYAN);
        map.setPreferredSize (new Dimension(1500,1000));

        for (Continent c:  worldMap.getWorldMap().values())
        {
            ContinentMap continentMap = new ContinentMap();
            Continent continent = continentMap.setUpContinent(c.getName());
            JPanel jPanel = new JPanel(new GridBagLayout());
            jPanel.setBackground(Color.CYAN);
            for (Country country: continent.getContinent())
            {
                JButton jButton = new JButton(country.getName().toString());
                jButton.addActionListener(controller);
                if (continent.getName() == ContinentName.NorthAmerica)
                {
                    jButton.setBackground(Color.YELLOW);
                    jButton.setForeground(Color.black);
                    if (country.getName() == CountryName.Alaska)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 0;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.NorthwestTerritories)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 1;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.WesternCanada)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 1;
                        constraints.gridy = 3;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.CentralCanada)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 2;
                        constraints.gridy = 3;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.EasternCanada)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 3;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.WesternUS)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 1;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.EasternUS)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 2;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.CentralAmerica)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 1;
                        constraints.gridy = 6;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Greenland)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                }
                if (continent.getName() == ContinentName.SouthAmerica)
                {
                    jButton.setBackground(Color.RED);
                    jButton.setForeground(Color.white);
                    if (country.getName() == CountryName.Venezuela)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 7;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Peru)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 8;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Brazil)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 8;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Argentina)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 9;
                        jPanel.add(jButton, constraints);
                    }
                }
                if (continent.getName() == ContinentName.Europe)
                {
                    jButton.setBackground(Color.BLUE);
                    jButton.setForeground(Color.white);
                    if (country.getName() == CountryName.Iceland)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 2;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.GreatBritain)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 1;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Scandinavia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Ukraine)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 5;
                        constraints.gridy = 1;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.NorthernEurope)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 1;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.SouthernEurope)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.WesternEurope)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                }
                if (continent.getName() == ContinentName.Africa)
                {
                    jButton.setBackground(Color.ORANGE);
                    jButton.setForeground(Color.black);
                    if (country.getName() == CountryName.NorthAfrica)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Egypt)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 5;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.EastAfrica)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 5;
                        constraints.gridy = 3;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Congo)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 3;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.SouthAfrica)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 4;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Madagascar)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 10;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                }
                if (continent.getName() == ContinentName.Asia)
                {
                    jButton.setBackground(Color.GREEN);
                    jButton.setForeground(Color.black);
                    if (country.getName() == CountryName.Ural)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Afghanistan)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 1;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.MiddleEast)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 3;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }

                    if (country.getName() == CountryName.Siberia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 7;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Yakutsk)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 8;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Kamchatka)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 9;
                        constraints.gridy = 0;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Irkutsk)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 8;
                        constraints.gridy = 1;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Mongolia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 9;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.China)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 8;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.India)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 7;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Siam)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 8;
                        constraints.gridy = 4;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.Japan)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 10;
                        constraints.gridy = 2;
                        jPanel.add(jButton, constraints);
                    }
                }
                if (continent.getName() == ContinentName.Australia)
                {
                    jButton.setBackground(Color.MAGENTA);
                    jButton.setForeground(Color.white);
                    if (country.getName() == CountryName.Indonesia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 16;
                        constraints.gridy = 5;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.NewGuinea)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 17;
                        constraints.gridy = 6;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.WesternAustralia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 16;
                        constraints.gridy = 10;
                        jPanel.add(jButton, constraints);
                    }
                    if (country.getName() == CountryName.EasternAustralia)
                    {
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.gridx = 17;
                        constraints.gridy = 10;
                        jPanel.add(jButton, constraints);
                    }
                }
            }
            if (continent.getName() == ContinentName.NorthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                map.add(jPanel, constraints);
            }
            if (continent.getName() == ContinentName.SouthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.anchor = GridBagConstraints.CENTER; // Change to LAST_LINE_START;
                map.add(jPanel, constraints);
            }
            if (continent.getName() == ContinentName.Europe)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.PAGE_START;
                map.add(jPanel, constraints);
            }
            if (continent.getName() == ContinentName.Africa)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 1;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.CENTER;
                map.add(jPanel, constraints);
            }
            if (continent.getName() == ContinentName.Asia)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_END;
                map.add(jPanel, constraints);
            }
            if (continent.getName() == ContinentName.Australia)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.LAST_LINE_END;
                map.add(jPanel, constraints);
            }
        }
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(cd, BorderLayout.WEST);
        container.add(map, BorderLayout.CENTER);
        container.add (test, BorderLayout.PAGE_END);
        this.setVisible(true);






    }
    @Override
    public void handleUpdate(GameEvent gameEvent) {
    }

    public static void main(String[] args) {
        new Frame();
    }
}
