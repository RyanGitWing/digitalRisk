import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 */

public class RiskFrame extends JFrame implements RiskView{

    private JMenuItem quitGame, saveGame, loadGame, help;

    private JButton atk, stat, nTurn;

    private Game riskGame;

    private JTextArea worldNews;

    private int numPlayers;

    private RiskController riskCtrl;

    private Board worldMap;

    private JPanel map, centerPanel;

    private int numAtkArmy;

    private String atkC, defC;

    private static ImageIcon wImg;

    private String status;

    public RiskFrame() {

        super("Risk Game");

        wImg = new ImageIcon(getClass().getResource("map.png"));


        //The starter frame
        starter();
    }

    /**
     * This method creates the game frame after the user has picked the number
     * of players.
     */
    public void initializeGame() {

        riskGame = new Game(numPlayers);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        riskCtrl = new RiskController(riskGame); // modified to be field.

        worldMap = riskGame.getBoardMap();

        riskGame.addRiskView(this);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(2000,1000)); // changed width from 1500 to 2000
        this.pack();
        //Centering the frame to be in the middle of the screen
        this.setLocationRelativeTo(null);

        imgPanel();

        //Add the menu to the frame
        theMenu();

        //Add the text panel to the frame
        textPanel();

        //Add the commands to the frame
        cmdPanel();

        //Add the WorldMap to frame
        WorldMapGUI();

        status = riskGame._getGameStatus();
        worldNews.setText(status);
    }

    private void imgPanel() {

        centerPanel = new JPanel();
        centerPanel.setSize(1500,1000);

        JLabel label = new JLabel();
        label.setIcon(wImg);

        centerPanel.add(label);
        centerPanel.setVisible(true);
        this.add(centerPanel, BorderLayout.CENTER);

    }

    /**
     * This is a helper method for WorldMapGUI() which sets up a JPanel corresponding to its respective continent
     * that is filled with Country JButtons
     * */
    private JPanel continentPanel (Continent continent)
    {
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.setBackground(Color.WHITE);

        for (Country country: continent.getCountries())
        {
            //String countryInfo = "";
            //countryInfo += country.getArmyOccupied();
            JButton jButton = new JButton(country.getCountryName().toString());
            jButton.setToolTipText(country.getRuler().getName() + " "  + "Army: " + country.getArmyOccupied());
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (e.getSource() instanceof JButton) {
                        atkC = e.getActionCommand();

                        if (riskGame.getCurrentPlayer().equals(country.getRuler())) {
                            adjSource(atkC);
                            numAtkArmy = country.getArmyOccupied();
                        } else {
                            JFrame jF = new JFrame();
                            JOptionPane.showMessageDialog(jF, "You don't own this country.", "Alert", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                    }
                }
            });
            jButton.setActionCommand(country.getCountryName().toString());
            jButton.setBackground(Color.black);
            if (continent.getName() == ContinentName.NorthAmerica)
            {
                jButton.setBackground(Color.YELLOW);
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
                jButton.setBackground(Color.RED);
                jButton.setForeground(Color.WHITE);
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
                jButton.setBackground(Color.BLUE);
                jButton.setForeground(Color.WHITE);
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
                jButton.setBackground(Color.ORANGE);
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
                jButton.setBackground(Color.GREEN);
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
                jButton.setBackground(Color.MAGENTA);
                jButton.setForeground(Color.WHITE);
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

    /**
     *  This panel displays the WorldMap to the user.
     * */
    private void WorldMapGUI ()
    {

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setSize(1500, 1000);
        p.setBackground(Color.WHITE);

        worldMap = riskGame.getBoardMap();
        map = new JPanel(new GridBagLayout());
        map.setBackground(Color.WHITE);
        map.setPreferredSize (new Dimension(1500,1000));

        JLabel aLabel = new JLabel("Which Country would you like to attack with?");
        aLabel.setHorizontalAlignment(JLabel.CENTER);
        aLabel.setVerticalAlignment(JLabel.CENTER);

        for (Continent c:  worldMap.getBoardMap().values())
        {
            JPanel jPanel = continentPanel(c);
            if (c.getName() == ContinentName.NorthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                map.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.SouthAmerica)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.anchor = GridBagConstraints.CENTER; // Change to LAST_LINE_START;
                map.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Europe)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.anchor = GridBagConstraints.PAGE_START;
                map.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Africa)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 1;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.CENTER;
                map.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Asia)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 0;
                constraints.anchor = GridBagConstraints.FIRST_LINE_END;
                map.add(jPanel, constraints);
            }
            if (c.getName() == ContinentName.Australia)
            {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx  = 2;
                constraints.gridy  = 1;
                constraints.anchor = GridBagConstraints.LAST_LINE_END;
                map.add(jPanel, constraints);
            }
        }

        p.add(aLabel, BorderLayout.NORTH);
        p.add(map, BorderLayout.CENTER);
        this.add(p, BorderLayout.CENTER);
        map.setVisible(false);
    }

    private void theMenu(){

        //Making the menu bar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //A game menu for menu bar
        JMenu aMenu = new JMenu("File");
        menuBar.add(aMenu);

        //A load game item for menu (for M4)
        loadGame = new JMenuItem("Load Game");
        aMenu.add(loadGame);

        //A save game item for menu (for M4)
        saveGame = new JMenuItem("Save");
        aMenu.add(saveGame);

        //A quit game item for menu
        quitGame = new JMenuItem("Quit");
        aMenu.add(quitGame);

        //A help item that display what the player can do
        help = new JMenuItem("Help");
        aMenu.add(help);


        //exits the game when used
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Help!");
                String s = "Attack: Select a country you own, a country to attack, and the number of troop. \n";
                s += "Game Status: Display the current state of the game \n";
                s += "Endturn: end your turn. \n";
                JOptionPane.showMessageDialog(f, s);
            }
        });


    }

    /**
     * This panel holds all the commands the player can use.
     */
    private void cmdPanel() {

        // Dice dice = new Dice();
        
        //Create the panel to store the buttons and the Dice
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(300, 0));
        westPanel.setBackground(Color.CYAN);

        //Make the attack button
        atk = new JButton("Attack");
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.setVisible(false);
                map.setVisible(true);
                atk.setEnabled(false);

            }
        });

        //Make the status button
        stat = new JButton("Game Status");
        stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = riskGame._getGameStatus();
                worldNews.append("\n" + status);
            }
        });

        //Make the endturn button
        nTurn = new JButton("Endturn");
        nTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskGame.nextPlayer();
                status = riskGame._getGameStatus();
                worldNews.append("\n" + status);
                atk.setEnabled(true);
                map.setVisible(false);
                centerPanel.setVisible(true);
            }
        });

        //A box to store the buttons inside
        Box box = Box.createVerticalBox();

        //Adding atk to the box, aligning it, and spacing it from the following button
        box.add(atk);
        box.add(Box.createVerticalStrut(10));
        atk.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding status to the box, aligning it, and spacing it from the following button
        box.add(stat);
        box.add(Box.createVerticalStrut(500));
        stat.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding endturn to the box, aligning it
        box.add(nTurn);
        nTurn.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding the box to the panel
        westPanel.add(box);


        //Adding the panel to the west side of the frame
        this.add(westPanel, BorderLayout.WEST);
        this.setVisible(true);

        //playerStatPanel.add(dice ,BorderLayout.SOUTH);

    }

    /**
     * This panel displays the information of the game, like the current state of the game.
     *
     */
    private void textPanel() {

        //Create a panel for the text
        JPanel southPanel = new JPanel();
        //Nice little design layout for the title of the panel
        southPanel.setBorder(new TitledBorder(new EtchedBorder(), "World News"));

        //Make a text area that resides in the panel
        worldNews = new JTextArea(16, 130);
        worldNews.setEditable(false);
        //Make it scrollable
        JScrollPane scroll = new JScrollPane(worldNews);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add the scroll to the panel
        southPanel.add(scroll);

        //Add the panel to the south side of the frame
        this.add(southPanel, BorderLayout.SOUTH);

        //Scroll automatically goes at the bottom of the text
        DefaultCaret caret = (DefaultCaret) worldNews.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    }

    /**
     * Creates a frame that request the users to select the amount of players
     * playing the game and starts the game once selected
     */
    private void starter() {

        JFrame f = new JFrame();

        f.setTitle("Risk!");

        f.setLayout(new BorderLayout());
        f.setSize(500,100);

        //A panel for the buttons
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        //A label that shows a text requesting the user to do something
        JLabel label = new JLabel("\n Select the number of Players playing.");
        //Align the label to be centered to the frame
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        //Creating the buttons for each number of players
        // todo refactor to be fooorrrr loooopppp
        JButton b2 = new JButton("2 Players");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 2;
                f.dispose();
                initializeGame();
            }
        });

        JButton b3 = new JButton("3 Players");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 3;
                f.dispose();
                initializeGame();
            }
        });

        JButton b4 = new JButton("4 Players");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 4;
                f.dispose();
                initializeGame();
            }
        });

        JButton b5 = new JButton("5 Players");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 5;
                f.dispose();
                initializeGame();
            }
        });

        JButton b6 = new JButton("6 Players");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 6;
                f.dispose();
                initializeGame();
            }
        });

        //Adding the buttons to the panel

        aPanel.add(b2);
        aPanel.add(b3);
        aPanel.add(b4);
        aPanel.add(b5);
        aPanel.add(b6);

        //Spacing the panel away from the label
        aPanel.add(Box.createVerticalStrut(50));

        //Adding the label to North and the panel to the Center
        f.add(label, BorderLayout.NORTH);
        f.add(aPanel, BorderLayout.CENTER);

        //Centering the frame to be in the middle of the screen
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);

    }

    public void adjSource(String cN) {
        Country c = worldMap.getCountry(CountryName.valueOf(cN));

        JFrame f = new JFrame();

        f.setTitle("Adjacent Countries");

        f.setLayout(new BorderLayout());
        f.setSize(500,100);

        //A panel for the buttons
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        //A label that shows a text requesting the user to do something
        JLabel label = new JLabel("\n Select the Country to attack.");
        //Align the label to be centered to the frame
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        List <CountryName> countryOwnAdj = c.getAdjCountries();

        for (CountryName countryName : countryOwnAdj) {
            JButton b = new JButton(countryName.toString());
            Country country = worldMap.getCountry(countryName);
            b.setToolTipText(country.getRuler().getName() + " "  + "Army: " + country.getArmyOccupied());
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    defC = e.getActionCommand();
                    f.dispose();
                    armySource();
                    riskGame._getGameStatus();
                }
            });
            aPanel.add(b);
        }

        //Spacing the panel away from the label
        aPanel.add(Box.createVerticalStrut(50));

        //Adding the label to North and the panel to the Center
        f.add(label, BorderLayout.NORTH);
        f.add(aPanel, BorderLayout.CENTER);

        //Centering the frame to be in the middle of the screen
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(true);

    }

    private void armySource(){

        JFrame f = new JFrame();

        f.setTitle("Adjacent Countries");

        f.setLayout(new BorderLayout());
        f.setSize(500,100);

        //A panel for the buttons
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        //A label that shows a text requesting the user to do something
        JLabel label = new JLabel("\n Select the number of army to attack with.");
        //Align the label to be centered to the frame
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);


        if (numAtkArmy > 3) {
            numAtkArmy = 3;
        }

        for (int i = 0; i < numAtkArmy; i++){
            JButton b = new JButton((i + 1) + "");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    status = riskGame._getGameStatus();
                    worldNews.append(riskGame.attackCMD(atkC, numAtkArmy, defC));
                    worldNews.append("\n" + status);
                    map.setVisible(false);
                    centerPanel.setVisible(true);
                }
            });
            aPanel.add(b);
        }

        //Spacing the panel away from the label
        aPanel.add(Box.createVerticalStrut(50));

        //Adding the label to North and the panel to the Center
        f.add(label, BorderLayout.NORTH);
        f.add(aPanel, BorderLayout.CENTER);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(true);

        atk.setEnabled(true);


    }

    public static void main(String[] args) {
        new RiskFrame();
    }

    @Override
    public void handleGameUpdate(RiskEvent e) {
    riskGame = (Game) e.getSource();
    worldNews.append(riskGame._getGameStatus());

    }
}